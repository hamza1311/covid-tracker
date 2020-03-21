/*
Copyright (c) 2010 Daniel Abrahamsson

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

/**
 * jsI18n library.
 * Simple client side internationalization.
 *
 * @version 1.1.1
 * @author Daniel Abrahamsson 2010 for the original library, Benjozork for the ES6 class conversion and JSDoc
 *
 * Copyright (c) Daniel Abrahamsson 2010
**/
export default class JsI18n {

    /**
     * Current locale
     *
     * @type {string}
     */
    #locale = "";
    /**
     * Available locales
     *
     * @type {object[]}
     */
    #locales = [];

    /**
     * Method for automatically detecting the language, does not work in every browser.
     *
     * @param {function(string): void} successCB
     * @param {function(): void} errorCB
    */
    detectLanguage(successCB, errorCB) {
        // noinspection JSUnresolvedVariable
        if (navigator.globalization !== null && navigator.globalization !== undefined) { // Phonegap browser detection
            // noinspection JSUnresolvedFunction,JSUnresolvedVariable
            navigator.globalization.getPreferredLanguage (
                language => language |> successCB,
                error => error |> errorCB
            );
        } else if (window.navigator.language !== null && window.navigator.language !== undefined) { //Normal browser detection
            successCB(window.navigator.language);
        }
    }

    /**
     * Helper for translating a node
     * and all its child nodes.
     *
     * @param {(HTMLElement|ChildNode)} node
    */
    processNode(node) {

        /**
         * Replace the content of the given node if there is a translation for the given key.
         *
         * @param {HTMLElement} node
         * @param {string} key
         */
        const translateNodeContent = (node, key) => {
            const translation = this.t(key) // Hack, "this" does not work
            if (node != null && translation) {
                if (node.nodeType === 1) // Element
                {
                    try {
                        node.innerHTML = translation
                    } catch (e) {
                        node.text = translation
                    }
                } else if (node.nodeType === 2) // Attribute
                    node.value = translation
            }
        };

        /**
         * Translates tag contents and attributes depending on the value of key.
         *
         * @param {HTMLElement} node
         * @param {string} key
         */
        const translateTag = (node, key) => {
            if (key.indexOf("=") === -1) { // Simple key
                translateNodeContent(node, key)
            } else { // Attribute/key pairs
                const parts = key.toLowerCase().split(";")

                for (let i = 0; i < parts.length; i++) {
                    const [left, right] = parts[i].split("="),
                        attr = left.trim(),
                        key = right.trim();

                    if (attr === "html") {
                        translateNodeContent(node, key)
                    } else {
                        translateNodeContent(node.attributes[attr], key)
                    }
                }
            }
        }

        if (node) {
            if (node.nodeType === 1) { //Element node
                const key = node.attributes["data-trans"]
                if (key != null) translateTag(node, key.nodeValue)
            }

            //Process child nodes
            const children = node.childNodes

            for (let i = 0; i < children.length; i++) {
                this.processNode(children[i])
            }
        }

    }

    /**
     *  Adds a locale to the list, replacing the translations if the locale is already defined.
     *
     * @param locale {string}
     * @param translations {object}
     */
    addLocale(locale, translations) {
        this.#locales[locale.toString()] = translations
    }

    /**
     * Sets the locale to use when translating.
     *
     * @param locale {string}
     */
    setLocale(locale) {
        this.#locale = locale
    }

    /**
     * Fetches the translation associated with the given key.
     *
     * @param key {string}
     */
    t(key) {
        const translations = this.#locales[this.#locale]
        if (translations) {
            return translations[key.toString()]
        }
        return undefined;
    }

    /**
     * Alias for JsI18n.t
     *
     * @param key {string}
     */
    translate(key) {
        this.t(key)
    }

    /**
     * Replaces the contents of all tags
     * that have the data-trans attribute set.
     */
    processPage() {
        this.processNode(document.getElementsByTagName("html")[0])
    }

}

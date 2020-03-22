import JsI18n from '../lib/jsi18n';

import fr from '../i18n/fr.json';

export function translate() {
    const i18n = new JsI18n();

    i18n.addLocale('fr', fr);

    i18n.detectLanguage (
        (locale: string) => { i18n.setLocale(locale); }, () => {}
    );

    document.querySelector('body').onload = () => {
        i18n.processPage();
    };
}

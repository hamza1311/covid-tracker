package utils

val countries = mapOf(
    "AF" to "Afghanistan",
    "AX" to "Åland Islands",
    "AL" to "Albania",
    "DZ" to "Algeria",
    "AS" to "American Samoa",
    "AD" to "Andorra",
    "AO" to "Angola",
    "AI" to "Anguilla",
    "AQ" to "Antarctica",
    "AG" to "Antigua and Barbuda",
    "AR" to "Argentina",
    "AM" to "Armenia",
    "AW" to "Aruba",
    "AU" to "Australia",
    "AT" to "Austria",
    "AZ" to "Azerbaijan",
    "BS" to "Bahamas",
    "BH" to "Bahrain",
    "BD" to "Bangladesh",
    "BB" to "Barbados",
    "BY" to "Belarus",
    "BE" to "Belgium",
    "BZ" to "Belize",
    "BJ" to "Benin",
    "BM" to "Bermuda",
    "BT" to "Bhutan",
    "BO" to "Bolivia, Plurinational State of",
    "BQ" to "Bonaire, Sint Eustatius and Saba",
    "BA" to "Bosnia and Herzegovina",
    "BW" to "Botswana",
    "BV" to "Bouvet Island",
    "BR" to "Brazil",
    "IO" to "British Indian Ocean Territory",
    "BN" to "Brunei Darussalam",
    "BG" to "Bulgaria",
    "BF" to "Burkina Faso",
    "BI" to "Burundi",
    "KH" to "Cambodia",
    "CM" to "Cameroon",
    "CA" to "Canada",
    "CV" to "Cape Verde",
    "KY" to "Cayman Islands",
    "CF" to "Central African Republic",
    "TD" to "Chad",
    "CL" to "Chile",
    "CN" to "China",
    "CX" to "Christmas Island",
    "CC" to "Cocos (Keeling) Islands",
    "CO" to "Colombia",
    "KM" to "Comoros",
    "CG" to "Congo",
    "CD" to "Congo, the Democratic Republic of the",
    "CK" to "Cook Islands",
    "CR" to "Costa Rica",
    "CI" to "Côte d'Ivoire",
    "HR" to "Croatia",
    "CU" to "Cuba",
    "CW" to "Curaçao",
    "CY" to "Cyprus",
    "CZ" to "Czech Republic",
    "DK" to "Denmark",
    "DJ" to "Djibouti",
    "DM" to "Dominica",
    "DO" to "Dominican Republic",
    "EC" to "Ecuador",
    "EG" to "Egypt",
    "SV" to "El Salvador",
    "GQ" to "Equatorial Guinea",
    "ER" to "Eritrea",
    "EE" to "Estonia",
    "ET" to "Ethiopia",
    "FK" to "Falkland Islands (Malvinas)",
    "FO" to "Faroe Islands",
    "FJ" to "Fiji",
    "FI" to "Finland",
    "FR" to "France",
    "GF" to "French Guiana",
    "PF" to "French Polynesia",
    "TF" to "French Southern Territories",
    "GA" to "Gabon",
    "GM" to "Gambia",
    "GE" to "Georgia",
    "DE" to "Germany",
    "GH" to "Ghana",
    "GI" to "Gibraltar",
    "GR" to "Greece",
    "GL" to "Greenland",
    "GD" to "Grenada",
    "GP" to "Guadeloupe",
    "GU" to "Guam",
    "GT" to "Guatemala",
    "GG" to "Guernsey",
    "GN" to "Guinea",
    "GW" to "Guinea-Bissau",
    "GY" to "Guyana",
    "HT" to "Haiti",
    "HM" to "Heard Island and McDonald Islands",
    "VA" to "Holy See (Vatican City State)",
    "HN" to "Honduras",
    "HK" to "Hong Kong",
    "HU" to "Hungary",
    "IS" to "Iceland",
    "IN" to "India",
    "ID" to "Indonesia",
    "IR" to "Iran, Islamic Republic of",
    "IQ" to "Iraq",
    "IE" to "Ireland",
    "IM" to "Isle of Man",
    "IL" to "Israel",
    "IT" to "Italy",
    "JM" to "Jamaica",
    "JP" to "Japan",
    "JE" to "Jersey",
    "JO" to "Jordan",
    "KZ" to "Kazakhstan",
    "KE" to "Kenya",
    "KI" to "Kiribati",
    "KP" to "Korea, Democratic People's Republic of",
    "KR" to "Korea, Republic of",
    "KW" to "Kuwait",
    "KG" to "Kyrgyzstan",
    "LA" to "Lao People's Democratic Republic",
    "LV" to "Latvia",
    "LB" to "Lebanon",
    "LS" to "Lesotho",
    "LR" to "Liberia",
    "LY" to "Libya",
    "LI" to "Liechtenstein",
    "LT" to "Lithuania",
    "LU" to "Luxembourg",
    "MO" to "Macao",
    "MK" to "Macedonia, the Former Yugoslav Republic of",
    "MG" to "Madagascar",
    "MW" to "Malawi",
    "MY" to "Malaysia",
    "MV" to "Maldives",
    "ML" to "Mali",
    "MT" to "Malta",
    "MH" to "Marshall Islands",
    "MQ" to "Martinique",
    "MR" to "Mauritania",
    "MU" to "Mauritius",
    "YT" to "Mayotte",
    "MX" to "Mexico",
    "FM" to "Micronesia, Federated States of",
    "MD" to "Moldova, Republic of",
    "MC" to "Monaco",
    "MN" to "Mongolia",
    "ME" to "Montenegro",
    "MS" to "Montserrat",
    "MA" to "Morocco",
    "MZ" to "Mozambique",
    "MM" to "Myanmar",
    "NA" to "Namibia",
    "NR" to "Nauru",
    "NP" to "Nepal",
    "NL" to "Netherlands",
    "NC" to "New Caledonia",
    "NZ" to "New Zealand",
    "NI" to "Nicaragua",
    "NE" to "Niger",
    "NG" to "Nigeria",
    "NU" to "Niue",
    "NF" to "Norfolk Island",
    "MP" to "Northern Mariana Islands",
    "NO" to "Norway",
    "OM" to "Oman",
    "PK" to "Pakistan",
    "PW" to "Palau",
    "PS" to "Palestine, State of",
    "PA" to "Panama",
    "PG" to "Papua New Guinea",
    "PY" to "Paraguay",
    "PE" to "Peru",
    "PH" to "Philippines",
    "PN" to "Pitcairn",
    "PL" to "Poland",
    "PT" to "Portugal",
    "PR" to "Puerto Rico",
    "QA" to "Qatar",
    "RE" to "Réunion",
    "RO" to "Romania",
    "RU" to "Russian Federation",
    "RW" to "Rwanda",
    "BL" to "Saint Barthélemy",
    "SH" to "Saint Helena, Ascension and Tristan da Cunha",
    "KN" to "Saint Kitts and Nevis",
    "LC" to "Saint Lucia",
    "MF" to "Saint Martin (French part)",
    "PM" to "Saint Pierre and Miquelon",
    "VC" to "Saint Vincent and the Grenadines",
    "WS" to "Samoa",
    "SM" to "San Marino",
    "ST" to "Sao Tome and Principe",
    "SA" to "Saudi Arabia",
    "SN" to "Senegal",
    "RS" to "Serbia",
    "SC" to "Seychelles",
    "SL" to "Sierra Leone",
    "SG" to "Singapore",
    "SX" to "Sint Maarten (Dutch part)",
    "SK" to "Slovakia",
    "SI" to "Slovenia",
    "SB" to "Solomon Islands",
    "SO" to "Somalia",
    "ZA" to "South Africa",
    "GS" to "South Georgia and the South Sandwich Islands",
    "SS" to "South Sudan",
    "ES" to "Spain",
    "LK" to "Sri Lanka",
    "SD" to "Sudan",
    "SR" to "Suriname",
    "SJ" to "Svalbard and Jan Mayen",
    "SZ" to "Swaziland",
    "SE" to "Sweden",
    "CH" to "Switzerland",
    "SY" to "Syrian Arab Republic",
    "TW" to "Taiwan, Province of China",
    "TJ" to "Tajikistan",
    "TZ" to "Tanzania, United Republic of",
    "TH" to "Thailand",
    "TL" to "Timor-Leste",
    "TG" to "Togo",
    "TK" to "Tokelau",
    "TO" to "Tonga",
    "TT" to "Trinidad and Tobago",
    "TN" to "Tunisia",
    "TR" to "Turkey",
    "TM" to "Turkmenistan",
    "TC" to "Turks and Caicos Islands",
    "TV" to "Tuvalu",
    "UG" to "Uganda",
    "UA" to "Ukraine",
    "AE" to "United Arab Emirates",
    "GB" to "United Kingdom",
    "US" to "United States",
    "UM" to "United States Minor Outlying Islands",
    "UY" to "Uruguay",
    "UZ" to "Uzbekistan",
    "VU" to "Vanuatu",
    "VE" to "Venezuela, Bolivarian Republic of",
    "VN" to "Viet Nam",
    "VG" to "Virgin Islands, British",
    "VI" to "Virgin Islands, U.S.",
    "WF" to "Wallis and Futuna",
    "EH" to "Western Sahara",
    "YE" to "Yemen",
    "ZM" to "Zambia",
    "ZW" to "Zimbabwe"
)
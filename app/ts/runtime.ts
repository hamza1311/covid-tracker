import { presentForGlobal, setupLocationChoices } from "./presentator";
import { translate } from "./translation";

translate();
// noinspection JSIgnoredPromiseFromCall
setupLocationChoices();
presentForGlobal();

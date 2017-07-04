(ns ^:figwheel-no-load {{project-ns}}.dev
  (:require
    [{{project-ns}}.core :as core]
    [devtools.core :as devtools]))


(enable-console-print!)

(devtools/install!)

(core/init!)

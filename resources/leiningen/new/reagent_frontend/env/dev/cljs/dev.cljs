(ns ^:figwheel-no-load {{project-ns}}.dev
  (:require
    [{{project-ns}}.core :as core]
    [devtools.core :as devtools]
    [figwheel.client :as figwheel :include-macros true]))

(figwheel/watch-and-reload
  :websocket-url "ws://localhost:3449/figwheel-ws"
  :jsload-callback core/mount-root)

(enable-console-print!)

(devtools/install!)

(core/init!)

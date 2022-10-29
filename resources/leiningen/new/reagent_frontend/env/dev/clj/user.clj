{{#shadow-cljs-hook?}}
(ns user
  (:require
   [shadow.cljs.devtools.api :as shadow]
   [ring.middleware.resource :refer [wrap-resource]]))

(defn cljs []
  (shadow/repl :app))
{{/shadow-cljs-hook?}}
{{#figwheel-hook?}}
(ns user
 (:require [figwheel-sidecar.repl-api :as ra]))

(defn start-fw []
 (ra/start-figwheel!))

(defn stop-fw []
 (ra/stop-figwheel!))

(defn cljs []
 (ra/cljs-repl))
{{/figwheel-hook?}}

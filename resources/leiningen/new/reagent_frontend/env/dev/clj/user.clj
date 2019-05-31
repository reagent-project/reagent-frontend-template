{{#shadow-cljs-hook?}}
(ns user (:require [ring.middleware.resource :refer [wrap-resource]]))

(def app (wrap-resource identity "public"))
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

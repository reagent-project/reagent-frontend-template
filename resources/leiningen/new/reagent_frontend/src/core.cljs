(ns {{project-ns}}.core
    (:require
      [reagent.core :as r]))

;; -------------------------
;; Views

(defn home-page []
  [:div [:h2 "Welcome to Reagent"]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn {{#shadow-cljs-hook?}}^:export {{/shadow-cljs-hook?}}init! []
  (mount-root))

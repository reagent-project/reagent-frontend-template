(ns leiningen.new.reagent-frontend
  (:require [leiningen.new.templates
             :refer [renderer name-to-path ->files
                     sanitize sanitize-ns project-name]]
            [leiningen.core.main :as main]))

(def render (renderer "reagent_frontend"))

(defn jvm>8? []
  (try
    (> (Double/parseDouble (subs (System/getProperty "java.version") 0 3)) 1.8)
    (catch Exception _)))

(def valid-opts ["+figwheel" "+shadow-cljs"])

(defn shadow-cljs? [opts]
      (some #{"+shadow-cljs"} opts))

(defn compiler [opts]
      (if (shadow-cljs? opts)
        {:shadow-cljs-hook? true}
        {:figwheel-hook? true}))

(defn template-data [name opts]
  (merge
    {:full-name name
     :name (project-name name)
     :project-goog-module (sanitize (sanitize-ns name))
     :project-ns (sanitize-ns name)
     :sanitized (name-to-path name)}
    (compiler opts)))

(defn shadow-cljs-assets [data]
  [["package.json" (render "package.json" data)]
   ["shadow-cljs.edn" (render "shadow-cljs.edn" data)]
   ["project.clj" (render "project.clj" data)]
   ["project.clj" (render "project.clj" data)]])

(defn generate [name opts]
  (let [data (template-data name opts)]
    (apply
      ->files
      data
      ["project.clj" (render "project.clj" data)]
      ["public/css/site.css" (render "public/css/site.css" data)]
      ["public/index.html" (render "public/index.html" data)]
      ["src/{{sanitized}}/core.cljs" (render "src/core.cljs" data)]
      ["env/dev/clj/user.clj" (render "env/dev/clj/user.clj" data)]
      ["env/dev/cljs/{{sanitized}}/dev.cljs" (render "env/dev/cljs/dev.cljs" data)]
      ["env/prod/cljs/{{sanitized}}/prod.cljs" (render "env/prod/cljs/prod.cljs" data)]
      ["LICENSE" (render "LICENSE" data)]
      ["README.md" (render "README.md" data)]
      [".gitignore" (render "gitignore" data)]
      (when (shadow-cljs? opts) (shadow-cljs-assets data)))))

(defn reagent-frontend [name & opts]
  (main/info "Generating fresh 'lein new' Reagent frontend project.")
  (generate name opts))

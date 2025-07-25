(ns todo.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.resource :refer [wrap-resource]]
            [clojure.java.io :as io]))

(defn home-page []
  (let [html (slurp (io/resource "public/home.html"))]
    {:status 200
     :headers {"Content-Type" "text/html"}
     :body html}))

(defn route-handler [request]
  (case (:uri request)
    "/" (home-page)
    ;; fallback 404
    {:status 404 :headers {"Content-Type" "text/plain"} :body "Not Found"}))

(def app
  ;; Serve static files from resources/public
  (wrap-resource route-handler "public"))

(defn -main []
  (println "Starting app at http://localhost:2000")
  (run-jetty app {:port 2000}))

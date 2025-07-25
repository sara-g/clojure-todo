(ns todo.core
  (:require [ring.adapter.jetty :refer [run-jetty]]))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/plan"}
   :body "ring is working"}
  )
  
(defn -main []
  (println "Starting app")
  (run-jetty handler {:port 2000}))
(ns shanghai.handler
  (:require [clojure.java.io :as io]
            [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET ["/:url", :url #".*"] [url]
    (io/resource (str "public/" url "/index.html")))
  (GET ["/user/:id", :id #"[0-9]+"] [id]
    (str "<h1>Hello user " id "</h1>"))
  (route/files "/")
  (route/resources "/")
  (route/not-found "<h1>Not Found</h1>"))

(def app
  (handler/site app-routes))

(ns clojuresque.core
  (:require [clojuresque.greet :as greet])
  (:require [clojuresque.all :as all])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (greet/hello-world-msg))
  )

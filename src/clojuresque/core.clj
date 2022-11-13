(ns clojuresque.core
  (:require [clojuresque.greet :as greet])
  (:require [clojuresque.agent-try :as agent-try])
  (:require [clojuresque.all :as all])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (greet/hello-world-msg))
  
  (println "calling agent")
  (agent-try/agent-ex)
  (println "after agent")
  
  )

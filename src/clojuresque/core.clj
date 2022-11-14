(ns clojuresque.core
  (:require [clojuresque.greet :as greet])
  (:require [clojuresque.agent-try :as agent-try])
  (:require [cheshire.core :as cheshire])
  (:require [clojuresque.all :as all])
  (:gen-class))


  (defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (greet/hello-world-msg))
  
  (println "calling agent")
  (agent-try/agent-ex)
  (println "after agent")
  
  (println (cheshire/generate-string {:name "kenny" :mood "happy"}))
  )

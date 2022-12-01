(ns clojuresque.core
  (:require [clojuresque.greet :as greet])
  (:require [clojuresque.numbers :as numbers])
  (:require [clojuresque.strings :as strings])
  (:require [clojuresque.lists :as lists])
  (:require [clojuresque.sets :as sets])
  (:require [clojuresque.vectors :as vectors])
  (:require [clojuresque.maps :as maps])
  (:require [clojuresque.records :as records])
  (:require [clojuresque.protocols :as protocols])
  (:require [clojuresque.deftypes :as deftypes])
  (:require [clojuresque.atoms :as atoms])
  (:require [clojuresque.transactions :as transactions])
  (:require [clojuresque.mathstuff :as mathstuff])
  (:require [clojuresque.functions :as functions])
  (:require [clojuresque.conditions :as conditions])
  (:require [clojuresque.looping :as looping])
  (:require [clojuresque.fileio :as fileio])
  (:require [clojuresque.destructuring :as destructuring])
  (:require [clojuresque.agent-try :as agent-try])
  (:require [cheshire.core :as cheshire])
  (:require [clojuresque.all :as all])
  (:gen-class))

  (defn -main
    "I don't do a whole lot ... yet."
    [& args]

    (greet/print-hello-world)
    (println (greet/hello-world-msg))


    (println "\n\n*** start") (println "press enter to start") (read-line)
    (destructuring/destructuring)
    (println "\npress enter to continue") (read-line)

    (numbers/numbers)
    (lists/lists)
    (strings/strings)
    (sets/sets)
    (vectors/vectors)
    (maps/maps)
    (records/records)
    (protocols/protocols) 
    (deftypes/deftypes)
    (atoms/atoms)
    (transactions/transactions)
    (mathstuff/mathstuff)
    (functions/functions)
    (conditions/conditions)
    (looping/looping)
    (fileio/fileio)
    
    
    (println "calling agent")
    (agent-try/agent-ex)
    (println "after agent")

    (println (cheshire/generate-string {:name "kenny" :mood "happy"})))

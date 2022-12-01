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
  
  (:require [clojuresque.transactions :as transactions])
  (:require [clojuresque.mathstuff :as mathstuff])
  (:require [clojuresque.functions :as functions])

  (:require [clojuresque.conditions :as conditions])
  (:require [clojuresque.looping :as looping])
  (:require [clojuresque.fileio :as fileio])
  
  (:require [clojuresque.destructuring :as destructuring])
  (:require [clojuresque.structs :as structs])
  (:require [clojuresque.lambdas :as lambdas]) 
  (:require [clojuresque.filters :as filters]) 
  (:require [clojuresque.macros :as macros]) 
  
  (:require [clojuresque.agent-try :as agent-try])

  (:require [cheshire.core :as cheshire])
  (:gen-class))

  #_{:clj-kondo/ignore [:unused-binding]}
  (defn -main
    "I don't do a whole lot ... yet."
    [& args]

    (greet/print-hello-world)
    (println (greet/hello-world-msg))

    ;; (println "\n\n*** start") (println "press enter to start") (read-line)
    ;; (println "\npress enter to continue") (read-line)

    (numbers/numbers)
    (lists/lists)
    (strings/strings)
    (sets/sets)
    
    (vectors/vectors)
    (maps/maps)
    (records/records)
    (protocols/protocols) 
    (deftypes/deftypes)
    
    (transactions/transactions)
    (mathstuff/mathstuff)
    (functions/functions)
    (conditions/conditions)
    (looping/looping)
    (fileio/fileio)
    (destructuring/destructuring)
    (structs/structs)
    (lambdas/lambdas)
    (filters/filters)
    (macros/macros) 
    
    (println "calling agent")
    (agent-try/agent-ex)
    (println "after agent")

    (println (cheshire/generate-string {:name "kenny" :mood "happy"}))
    )

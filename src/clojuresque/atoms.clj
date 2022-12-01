(ns clojuresque.atoms)

;; Redo this section.  Need a better example without inline def.

(def vx 5)

(def vatom (atom vx))

(defn atom-ex [x]
  (def atomEx (atom x))
  (add-watch atomEx :watcher
             (fn [key atom old-state new-state]
               (println "atomEx changed from "
                        old-state " to " new-state)))
  (println "1st x" @atomEx)
  (reset! atomEx 10)
  (println "2nd x" @atomEx)
  (swap! atomEx inc)
  (println "Increment x" @atomEx))

(defn atoms []
  ,,,(println "atoms:")
  (println @vatom)  ; 5 
  (swap! vatom (fn [x] (+ x 3)))
  (println @vatom)  ; 8  
  (atom-ex 5))
(ns clojuresque.sets
  (:require [clojure.set :refer [union, difference, intersection, subset?]])
  )

(def set1 (set '(4 5 6)))

(defn sets []
  
  ,,,(println "sets:")
  ,,, (println #{1 2 3})  ; #{ 1 3 2 }
  ,,, (println (set (list 1 1 2)))  ; #{1 2}
  ,,, (println (get set1 6))  ; 6
  ,,, (println (get set1 66))  ; nil
  ,,, (println (contains? set1 6))  ; true
  ,,, (println (conj set1 7))  ; #{ 7 4 6 5 }
  ,,, (println (disj set1 4))  ; #{ 6 5 }
  ,,, (println (union set1 #{4 5}))  ; #{ 4 6 5 }
  ,,, (println (difference set1 #{4 5}))  ; #{ 6 }
  ,,, (println (intersection set1 #{4 5}))  ; #{ 4 5 }
  ,,, (println (subset? set1 #{4 5}))  ; false
  ,,, (println (list? set1))  ; false
  )

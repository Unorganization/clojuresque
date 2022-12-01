(ns clojuresque.lists)


(def list1 (list 4 5 6))

(defn lists []
  ,,,(println "lists:")
  ,,, (println '(1 2 3 "Dog", true, 4.2))
  ,,, (println list1)  ; (4 5 6)
  ,,, (println (first list1))  ; 4
  ,,, (println (rest list1))  ; (5 6)
  ,,, (println (nth list1 1))  ; 5
  ,,, (println (conj list1 3))  ; (3 4 5 6)
  ,,, (println (conj list1 3 2 1))  ; (1 2 3 4 5 6)
  ,,, (println (list* 3 list1))  ; (3 4 5 6)
  ,,, (println (list* 1 2 3 list1)) ; (1 2 3 4 5 6)
  ,,, (println (cons 3 list1))  ; (3 4 5 6)
  ,,, (println (into () list1))  ; (6 5 4)
  ,,, (println (peek list1))  ; 4
  ,,, (println (pop list1))  ; (5 6)
  ,,, (println (list? list1))  ; true
  (println `(1 2 3))  ; (1 2 3)
  )

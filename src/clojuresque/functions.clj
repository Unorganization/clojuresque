(ns clojuresque.functions)

(defn say-hello
  "Receives a name with 1 parameter and responds"
  [name]
  (println "Hello again" name))
    
(defn get-sum [x y]
  (+ x y))

    ; multi-arity function
(defn get-sum-more
  ([x y z]
   (+ x y z))

  ([x y]
   (+ x y)))

; doseq iterations over a sequence; can support nested loops
(defn print-elems [first & rest]
  (println first)
  (doseq [arg rest] (println arg)))

(defn hello-you [name]
  (str "Hello " name))

(defn hello-all [& names]
  (map hello-you names))

(defn functions []
  ,,, (println "functions:")
  (say-hello "bob")
  ,,, (println (get-sum 5 6))  ; 11

  ,,, (println (get-sum-more 6 7))  ; 13
  ,,, (println (get-sum-more 5 6 7))  ; 18
  (print-elems "First" "Second" 3 4 "Fifth")  ; First\nSecond\n3\n4\nFifth

  ,,,(println (hello-all "kenny" "michelle" "aaron")) ; (Hello kenny Hello michelle Hello aaron)
  )



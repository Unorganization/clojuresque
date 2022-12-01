(ns clojuresque.looping)

(def i (atom 1))

(defn one-to-x [x]
  (while (<= @i x)
    (do
      (println @i)
      (swap! i inc))))

    ; dotimes = used to run expression n times
(defn dbl-to-x [x]
  (dotimes [i x]
    (println (* i 2))))

(defn triple-to-x [x, y]
  (loop [i, x]
    (when (< i y)
      (println (* i 3))
      (recur (+ i 1)))))

(defn print-list
  [& nums]
  (doseq [x nums]
    (println x)))

(defn looping []
  ,,, (println "looping:")
  ,,, (println "one-to-x 5")  (one-to-x 5)  ; 1 \n 2 \n 3 \n 4 \n 5 \n
  ,,, (println "dbl-to-x 5")  (dbl-to-x 5)  ; 0 \n 2 \n 4 \n 6 \n 8 \n
  ,,, (println "triple-to-x 2 6")  (triple-to-x 2 6) ; 6 \n 9 \n 12 \n 15 \n

; for comprhension -- supports mult seqs, output captured
  (println (for [num-one [1 2 3]
                 num-two [4 5 6]]
             [num-one num-two]))  ; ([1 4] [1 5] [1 6] [2 4] [2 5] [2 6] [3 4] [3 5] [3 6])

  (print-list 7 8 9)  ; 7 \n 8 ; 9 \name

  (dotimes [n 5]
    (println (str "My number is: " n)))  ; My number is 0\n, etc. to 4 

    ; doseq output not captured
  (doseq [num-one [1 2 3]
          num-two [4 5 6]]
    (println num-one " " num-two))  ; 1 4\n 1 5\n 1 6\n, 2 4\n 2 5\n etc. to 3 6\n

  )
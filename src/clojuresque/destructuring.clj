(ns clojuresque.destructuring)

(def vectVals [1 2 3 4])
(defn destruct []
  (let [[one two & the-rest] vectVals]
    (println one two the-rest)))

(def apoint [5 7])

;; with arg list
(def ndx [1 2 3])

(def cpoint {:y 7})

(def bpoint {:x 5 :y 7})

(def book {:name "SICP" :details {:pages 657 :isbn-10 "0262011530"}})

(def nested_vector [[1 2] [3 4]])

; destructure both map and vecotr
(def golfer {:name "Jim" :scores [3 5 4 5]})

; destructuring in function def
(defn print-status [{name :name [hole1 hole2] :scores}]
  (println "name:" name "hole1:" hole1 "hole2:" hole2))

    
(defn destructuring []
  ,,, (println "destructuring:")
  (destruct)  ; 1 2 (3 4)

  ,,, (println ndx)  ; [1 2 3]
  ,,, (let [[x & more] ndx] (println x more))  ; 1 (2 3)
  ,,, (let [[x & more :as full-list] ndx]
        (println x more full-list))  ; 1 (2 3) [1 2 3]

;; or 
  ,,, (println cpoint)  ;; {:y 7}
  ,,, (let [{:keys [x y] :or {x 0 y 0}} cpoint]
        (println "x:" x "y:" y))  ; x: 0 y: 7

  ,,, (println bpoint)  ; {:x 5, :y 7}
  ,,, (let [{x :x y :y} bpoint]
        (println "x:" x "y:" y))  ; x: 5 y: 7
  ,,, (let [{:keys [x y]} bpoint]
        (println "x:" x "y:" y))  ; x: 5 y: 7
  ,,, (let [{:keys [x y] :as the-point} bpoint]
        (println "x:" x "y:" y "point:" the-point))
      ; x: 5 y: 7 point: {:x 5, :y 7}

  ,,, (println book)  ; {:name SICP, :details {:pages 657, :isbn-10 0262011530}}
  (let [{name :name {pages :pages isbn-10 :isbn-10} :details} book]
    (println "name:" name "pages:" pages "isbn-10:" isbn-10))
    ;;  name: SICP pages: 657 isbn-10: 0262011530


  ,,, (println nested_vector)  ;; [[1 2] [3 4]]
  (let [[[a b] [c d]] nested_vector]
    (println "a:" a "b:" b "c:" c "d:" d))  ;; a: 1 b: 2 c: 3 d: 4

  (let [{name :name [hole1 hole2] :scores} golfer]
    (println "name:" name "hole1:" hole1 "hole2:" hole2))
    ;; name: Jim hole1: 3 hole2: 5 

  (print-status {:name "Jim" :scores [3 5 4 5]})
  ;; name: Jim hole1: 3 hole2: 5

  ,,, (println apoint)  ; [5 7]
  ,,, (let [[x y] apoint] (println (+ x y)))  ; 12
  )
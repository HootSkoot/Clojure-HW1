(ns hw1.core
  (:require [clojure.tools.trace :as t])
  (:gen-class))

;;This is testing basic Clojure knowledge


(defn times3
  [x]
  (* x 3))

(defn sum-squares
  [x]
  (if (>= x 0) (+ (* x x) (sum-squares (- x 1))) 0))

(defn times-3-or-4
  [x]
  (if (odd? x) (* x 3) (if (even? x) (* x 4))))

(defn xcubed-plus-one
  [x]
  (+ (* x x x) 1))

(defn deposit
  [account amount]
  (assoc account :balance (+ (account :balance) amount)))

(defn account-str
  [account]
  (str "Account " (account :id) " owned by " (account :owner) " with balance $" (account :balance)))

(defn duple
  [n x]
  (if (>= n 1) 
    (conj (duple (- n 1) x) x) 
    (if (= n 0)
      '())))

(defn reverse-two
  [lst]
  (list (last lst) (first lst)))

(defn invert
  [lst]
  (if (not(empty? lst))
  (conj (invert (rest lst)) (reverse-two (first lst)) ) '())) 

(defn make-list
  [x]
  (list x))
(defn down
  [lst]
  (if (not(empty? lst))
    (conj (down (rest lst)) (make-list (first lst)))
    '()
    )
  )


(defn list-set
            [lst n x]
             (concat (if (= n 0) 
                      [x] 
                      [(first lst)]
                      ) 
                    (if (and (not(empty? (rest lst))) (>= n 0) (< n (count lst))) 
                      (list-set (rest lst) (- n 1) x) 
                      (rest lst)
                      )
              )
            )

(defn count-occurrences
            [s lst]
            (if (list? lst)
              (if (empty? lst)
                0
                (+ (count-occurrences s (first lst)) (count-occurrences s (rest lst)))
                )
              (if (not(symbol? lst))
                (if (= s lst)
                  1
                  0)
                0
                )
              )
            )


(defn product-two
            [s lst2]
            (if (empty? lst2)
              '()
              (conj (product-two s (rest lst2)) (list s (first lst2))
              )))

(defn product
            [lst1 lst2]
            (if (empty? lst1)
                '()
                (concat (product-two (first lst1) lst2) (product (rest lst1) lst2)
                )
            ))




(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (println (product '(1 2 3) '(a b c)))
  )





(defn swapper
  [s1 s2 lst]
  
  (cond
(empty? lst) '()
(= (first lst) s1) (conj (swapper s1 s2 (rest lst) ) s2)
(= (first lst) s2) (conj (swapper s1 s2 (rest lst) ) s1)
(seq? (first lst)) (conj (swapper s1 s2 (rest lst)) (swapper  s1 s2 (first lst)))
:else (conj (swapper s1 s2 (rest lst)) (first lst)))
   
      
  )

            
;;All lines below this are practice

(comment (t/deftrace count-occurrences [s x]
  (if (symbol? x)
    (if (= x s) 1 0)
    (if (empty? x)
      0
      (+ (count-occurrences s (first x))
         (count-occurrences s (rest x)))))))
            
(comment (t/deftrace swap-helper
  [x y z]
  (cond 
    (= z x) y
    (= z y) x
    :else z)
  ))



(comment (t/deftrace swapper
  [s1 s2 slist]
  (if (not (empty? slist)) (conj (if (and (not(list? (first slist))) (not (nil? (first slist))))
          (cond 
             (= (first slist) s1) s2
             (= (first slist) s2) s1
             :else (first slist)) 
          (if (not (nil? (first slist))) (swapper s1 s2 (first slist))))
        (swapper s1 s2 (rest slist))))
  ))

(comment 
(t/deftrace swapper [s1 s2 slist]
  (conj (if (not (list? (first slist)))
           (cond 
             (= s1 (first slist)) s2
             (= s2 (first slist)) s1
             :else (first slist))
           (swapper s1 s2 (first slist)))
        (swapper s1 s2 (rest slist)))))

(comment (t/deftrace product
            [lst1 lst2]
            (let [snip (if (empty? lst1)
              '()
              (compose (first lst1) (first lst2))
              )]
              (conj (if (> (count lst2) 1) 
                        (product lst1 (rest lst2)))
                         )
                    snip
                    )
              ))
            

(comment (t/deftrace product
            [lst1 lst2]
            (let [snip (if (empty? lst1)
              '()
              (compose (first lst1) (first lst2))
              )]
              (conj (if (> (count lst2) 1) 
                        (product lst1 (rest lst2))
                         (if (> (count lst1) 1) 
                        (product lst2 (rest lst1))
                        ))
                    snip
                    )
              )
            ))


(ns hw1.core-test
  (:require [clojure.test :refer :all]
            [hw1.core :refer :all]))

(deftest times3-tests
  (is (= 9 (times3 3)))
  (is (= 12 (times3 4))))

(deftest sum-squares-tests
  (is (= 14 (sum-squares 3)))
  (is (= 91 (sum-squares 6))))


(deftest times-3-or-4-tests
  (is (= 9 (times-3-or-4 3)))
  (is (= 16 (times-3-or-4 4)))
  (is (= 15 (times-3-or-4 5)))
  (is (= 24 (times-3-or-4 6))))

(deftest xcubed-plus-one-tests
  (is (= 9 (xcubed-plus-one 2)))
  (is (= 0 (xcubed-plus-one -1)))
  (is (= 1 (xcubed-plus-one 0)))
  (is (= 28 (xcubed-plus-one 3))))


(deftest deposit-tests
  (is (= 100
         (:balance (deposit {:balance 25} 75))))
  (is (= 1019
         (:balance (deposit {:balance 19} 1000))))
  (is (= "Fred" (:owner (deposit {:balance 99 :owner "Fred"} 500)))))

(deftest account-str-tests
  (is (= "Account 12983 owned by Fred with balance $1000"
         (account-str {:owner "Fred", :id 12983, :balance 1000})))
  (is (= "Account 13 owned by Barney Rubble with balance $50"
         (account-str {:owner "Barney Rubble", :id 13, :balance 50}))))

(deftest duple-tests
  (is (= '(5 5 5) (duple 3 5)))
  (is (= '((ha ha) (ha ha) (ha ha)) (duple 3 '(ha ha))))
  (is (= '(a a a a a a) (duple 6 'a)))
  (is (= () (duple 0 'anything))))

(deftest invert-tests
  (is (= '((1 2) (3 4))
         (invert '((2 1) (4 3)))))
  (is (= '((a b) (d c) (f e) (h g))
         (invert '((b a) (c d) (e f) (g h)))))
  (is (= '((b (c)) ((a) b))
         (invert '(((c) b) (b (a)))))))

(deftest down-tests
  (is (= () (down ())))
  (is (= '((1) (2)) (down '(1 2))))
  (is (= '(((1 2)) ((3 4))) (down '((1 2) (3 4))))))

(deftest list-set-tests
  (is (= '(1) (list-set '(a) 0 1)))
  (is (= '(99 2 3 4 5) (list-set '(1 2 3 4 5) 0 99)))
  (is (= '(a monkey c d) (list-set '(a b c d) 1 'monkey)))
  (is (= '(1 2 3 4 5 6)
         (list-set '(1 2 3 4 wrong 6) 4 5))))

(deftest count-occurrences-tests
  (is (= 0 (count-occurrences 1 '(2 3 4))))
  (is (= 1 (count-occurrences 1 '(1 2 3 4))))
  (is (= 1 (count-occurrences 1 '(2 1 3 4))))
  (is (= 2 (count-occurrences 1 '(1 2 1 3 4))))
  (is (= 3 (count-occurrences 1 '((1) (1) (2 3 1))))))

(deftest product-test
  (is (= () (product () '(1 2 3 4))))
  (is (= (frequencies '((a 1) (a 2)))
         (frequencies (product '(a) '(1 2)))))
  (is (= (frequencies
          '((a 1) (a 2) (b 1) (b 2)))
         (frequencies (product '(a b) '(1 2))))))


  (deftest swapper-tests
  ;(is (= () (swapper 'a 'b ())))
  ;(is (= '(1 2 3) (swapper 'a 'b '(1 2 3))))
  (is (= '(b a c) (swapper 'a 'b '(a b c))))
  (is (= '(b b b) (swapper 'a 'b '(a a a))))
  (is (= '((b a) (b a) c b a)
         (swapper 'a 'b '((a b) (a b) c a b))))
  (is (= '((((foo bar) biz) (biz bar foo (foo) bar)) biz)
         (swapper 'foo 'bar
                  '((((bar foo) biz) (biz foo bar (bar) foo)) biz)))))






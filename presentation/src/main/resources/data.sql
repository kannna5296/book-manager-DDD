INSERT INTO book (id, title, kana_title, author, kana_author, release_date) VALUES (1, 'アンパンマン', 'アンパンマン', 'やなせたかし', 'ヤナセタカシ',　'2020-10-20')
INSERT INTO book (id, title, kana_title, author, kana_author, release_date) VALUES (2, '1リットルの涙', 'イチリットルノナミダ', '木藤亜矢', 'キトウアヤ',　'2020-10-20')

INSERT INTO rental (id, user_id, book_id, rental_date, return_deadline) VALUES (1, 1, 2, '2021-01-01', '2021-01-08')
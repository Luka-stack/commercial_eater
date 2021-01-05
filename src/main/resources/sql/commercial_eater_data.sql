INSERT INTO cities (name) VALUES
('Zielona Gora'),
('Lodz'),
('Kielce'),
('Bialystok'),
('Wroclaw');

---------------------------------------------------------------------------------------

INSERT INTO users (email, password, firstName, lastName, city, role, balance) VALUES
('admin1@comeater.pl', '$2y$12$C0wBpBn5G/226gwke./YN.DNENNriKV0pBKwZzHTTtGiNM7G5MNpC', 'Super F Name', 'Super L Name', 1, 'Administrator', 100.5),
('user1@comeater.pl', '$2y$12$C0wBpBn5G/226gwke./YN.DNENNriKV0pBKwZzHTTtGiNM7G5MNpC', 'Noah', 'Last Name 29', 2, 'User', 20.2);

---------------------------------------------------------------------------------------

INSERT INTO restaurants (name, description, address) VALUES 
('Slodka Wloska', 'Here is description', 'City, Street and Numer'),
('Mafia', 'Here is description', 'City, Street and Numer'),
('Phenix', 'Here is description', 'City, Street and Numer');

---------------------------------------------------------------------------------------

INSERT INTO dishes (name, dishType, diet, price, restaurantId) VALUES
('Whole Chicken', 'MAIN_COURSES', 'NONE', 11.5, 1),
('Chicken Wings', 'MAIN_COURSES', 'NONE', 12.5, 2),
('Pepsi', 'DRINKS', 'NONE', 3.99, 3),
('Lemonade', 'DRINKS', 'NONE', 6.23, 1);

---------------------------------------------------------------------------------------

INSERT INTO transactions (dateTime, transactionType, amount, userId) VALUES
('2020-12-12', 'TOP_UP', 20.5, 1),
('2020-09-25', 'TOP_UP', 55.0, 2),
('2020-12-10', 'ORDER', 20.0, 1),
('2020-11-10', 'ORDER', 25.0, 2);

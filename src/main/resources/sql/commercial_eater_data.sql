INSERT INTO users (email, password, firstName, lastName, city, role, balance) VALUES
('admin1@comeater.pl', 'qwerty', 'Super F Name', 'Super L Name', 'London', 'Administrator', 100.5),
('admin2@comeater.pl', 'qwerty', 'Liam', 'Meh', 'Paris', 'Administrator', 50.5),
('user1@comeater.pl', 'qwerty', 'Noah', 'Last Name 29', 'Madrid', 'User', 20.2),
('user2@comeater.pl', 'qwerty', 'Jackson', 'Last Name 9', 'Berlin', 'User', 33.22),
('user3@comeater.pl', 'qwerty', 'Sophia', 'Last Name 1', 'Warsaw', 'User', 0.5),
('user4@comeater.pl', 'qwerty', 'Olivia', 'Last Name 2', 'Under Bridge', 'User', 5.5),
('user5@comeater.pl', 'qwerty', 'Riley', 'Last Name 5', 'Alone', 'User', 0.92),
('user6@comeater.pl', 'qwerty', 'Emma', 'Last Name 2', 'In', 'User', 0.23),
('user7@comeater.pl', 'qwerty', 'Ava', 'Last Name 2', 'Las Vegas', 'User', 20.00);

---------------------------------------------------------------------------------------

INSERT INTO restaurants (name, description, address) VALUES 
('Restaurant 1', 'Here is description', 'City, Street and Numer'),
('Restaurant 2', 'Here is description', 'City, Street and Numer'),
('Restaurant 3', 'Here is description', 'City, Street and Numer'),
('Restaurant 4', 'Here is description', 'City, Street and Numer'),
('Restaurant 5', 'Here is description', 'City, Street and Numer'),
('Restaurant 6', 'Here is description', 'City, Street and Numer'),
('Restaurant 7', 'Here is description', 'City, Street and Numer'),
('Restaurant 8', 'Here is description', 'City, Street and Numer'),
('Restaurant 9', 'Here is description', 'City, Street and Numer'),
('Restaurant 10', 'Here is description', 'City, Street and Numer'),
('Restaurant 11', 'Here is description', 'City, Street and Numer'),
('Restaurant 22', 'Here is description', 'City, Street and Numer'),
('Restaurant 33', 'Here is description', 'City, Street and Numer'),
('Restaurant 44', 'Here is description', 'City, Street and Numer'),
('Restaurant 55', 'Here is description', 'City, Street and Numer'),
('Restaurant 66', 'Here is description', 'City, Street and Numer'),
('Restaurant 77', 'Here is description', 'City, Street and Numer'),
('Restaurant 88', 'Here is description', 'City, Street and Numer'),
('Restaurant 99', 'Here is description', 'City, Street and Numer'),
('Restaurant 100', 'Here is description', 'City, Street and Numer'),

---------------------------------------------------------------------------------------

INSERT INTO transactions (dateTime, transactionType, amount, userId) VALUES
('2020-12-12', 'TOP_UP', 10.0, 1),
('2020-12-10', 'TOP_UP', 15.0, 4),
('2020-12-05', 'TOP_UP', 10.0, 5),
('2020-10-20', 'TOP_UP', 20.0, 10),
('2020-09-25', 'TOP_UP', 55.0, 12),
('2020-12-10', 'ORDER', 20.0, 12),
('2020-11-10', 'ORDER', 25.0, 5),
('2020-10-10', 'ORDER', 30.0, 1);
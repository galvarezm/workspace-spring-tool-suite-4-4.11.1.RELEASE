INSERT INTO `users` (username, password, enabled, name, last_name, email) VALUES ('galvarez','$2a$10$WA5WoKJRYLdkx3Zut1jZy.LQzx3G.RhoDWpYYRm1RB8Ees3x/IKDi',1, 'Gabriel', 'Alvarez','galvarez.2021@yopmail.com');
INSERT INTO `users` (username, password, enabled, name, last_name, email) VALUES ('admin','$2a$10$0p1bHWZlW39ZOumWbEwKbOCjlGv.5ypBkNHmGsxn3eAHsfkoEmR7m',1, 'Jose', 'Donoso','jose.donoso@yopmail.com');

INSERT INTO `roles` (name) VALUES ('ROLE_USER');
INSERT INTO `roles` (name) VALUES ('ROLE_ADMIN');

INSERT INTO `user_to_roles` (user_id, role_id) VALUES (1, 1);
INSERT INTO `user_to_roles` (user_id, role_id) VALUES (2, 1);
INSERT INTO `user_to_roles` (user_id, role_id) VALUES (2, 2);

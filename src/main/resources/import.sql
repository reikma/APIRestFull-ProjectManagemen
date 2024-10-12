
INSERT INTO usuarios (username, email, password) VALUES('johndoe', 'john@example.com', 'securepassword');
INSERT INTO usuarios (username, email, password) VALUES('janedoe', 'jane@example.com', 'anotherpassword'),
INSERT INTO usuarios (username, email, password) VALUES('alice', 'alice@example.com', 'password123');
INSERT INTO usuarios (username, email, password) VALUES('bob', 'bob@example.com', 'mypassword');
INSERT INTO usuarios (username, email, password) VALUES('charlie', 'charlie@example.com', 'charliepassword');
INSERT INTO usuarios (username, email, password) VALUES('dave', 'dave@example.com', 'davepassword');


INSERT INTO proyectos (name, description, owner_id) VALUES('Proyecto A', 'Descripción del Proyecto A', 1);
INSERT INTO proyectos (name, description, owner_id) VALUES('Proyecto B', 'Descripción del Proyecto B', 2);
INSERT INTO proyectos (name, description, owner_id) VALUES('Proyecto C', 'Descripción del Proyecto C', 1);
INSERT INTO proyectos (name, description, owner_id) VALUES('Proyecto D', 'Descripción del Proyecto D', 3);
INSERT INTO proyectos (name, description, owner_id) VALUES('Proyecto E', 'Descripción del Proyecto E', 4);


INSERT INTO tareas (title, description, due_date, assigned_to, project_id)VALUES('Tarea 1 de Proyecto A', 'Descripción de la tarea 1', '2024-10-15', 2, 1);
INSERT INTO tareas (title, description, due_date, assigned_to, project_id)VALUES('Tarea 2 de Proyecto A', 'Descripción de la tarea 2', '2024-10-20', 1, 1);
INSERT INTO tareas (title, description, due_date, assigned_to, project_id)VALUES('Tarea 1 de Proyecto B', 'Descripción de la tarea 1', '2024-10-25', 3, 2);
INSERT INTO tareas (title, description, due_date, assigned_to, project_id)VALUES('Tarea 1 de Proyecto C', 'Descripción de la tarea 1', '2024-10-30', 4, 3);
INSERT INTO tareas (title, description, due_date, assigned_to, project_id)VALUES('Tarea 1 de Proyecto D', 'Descripción de la tarea 1', '2024-10-05', 5, 4);
INSERT INTO tareas (title, description, due_date, assigned_to, project_id)VALUES('Tarea 2 de Proyecto D', 'Descripción de la tarea 2', '2024-10-12', 6, 4);
INSERT INTO tareas (title, description, due_date, assigned_to, project_id)VALUES('Tarea 1 de Proyecto E', 'Descripción de la tarea 1', '2024-10-22', 1, 5);


INSERT INTO comentarios (user_id, task_id, content) VALUES(1, 1, '¿Cuál es el estado de esta tarea?');
INSERT INTO comentarios (user_id, task_id, content) VALUES(2, 1, 'Estoy trabajando en ello.');
INSERT INTO comentarios (user_id, task_id, content) VALUES(3, 3, 'Necesito más información sobre esta tarea.');
INSERT INTO comentarios (user_id, task_id, content) VALUES(4, 2, 'Esta tarea está completa.');
INSERT INTO comentarios (user_id, task_id, content) VALUES(5, 4, 'Revisaré esta tarea mañana.');
INSERT INTO comentarios (user_id, task_id, content) VALUES(6, 5, 'Confirmado, empezaré hoy.');
INSERT INTO comentarios (user_id, task_id, content) VALUES(2, 6, 'Listo, la tarea se ha completado.');

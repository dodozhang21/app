insert into parents_user(id, username) values (500, 'bubo');
insert into parents_user(id, username) values (null, 'misty');
insert into parents_checklist(id, user_id, name, last_updated) values (600, 500, 'bubos existing list', '2013-11-22 06:00:00.0');
insert into parents_checklist_task(checklist_id, description, completed) values (600, 'Task 1 Completed', 1);
insert into parents_checklist_task(checklist_id, description, completed) values (600, 'Task 2 Not Completed', 0);
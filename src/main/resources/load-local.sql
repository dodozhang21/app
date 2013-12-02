insert into parents_user(id, username) values (1, 'admin');

insert into parents_checklist(id, user_id, name, last_updated) values (1, 1, "You're Pregnant! Now What?", NOW());

insert into parents_checklist_task(checklist_id, description, completed) values (1, "Make a date with your ob-gyn. Most initial prenatal checkups occur between weeks 6 and 10.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (1, "Skip that third Starbucks run. Most experts say you should stick to just one or two 8-ounce cups of java a day.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (1, "Kick those cigarettes to the curb. No excuses. Hey, there's never been a better time to quit, right?", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (1, "Cut out cocktails. Stock up on Pellegrino or any other special beverage you can swap in for that occasional round of Riesling.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (1, "Get the green light for your meds and skincare products -- even occasional over-the-counter stuff like pain-relievers.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (1, "Pop those prenatal vitamins. They contain the right amount of folic acid and iron, which are critical in baby's early development.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (1, "Pass on those spicy tuna rolls -- the raw fish may contain potentially harmful bacteria for your growing baby.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (1, "Same goes for undercooked meat, poultry, and eggs.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (1, "Skip farmer's market apple cider, unless you know it's pasteurized. Likewise for soft cheeses like brie.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (1, "Have your partner be kitty's primo caretaker. Her litter box may harbor a dangerous kind of bacteria.", 0);

insert into parents_checklist(id, user_id, name, last_updated) values (2, 1, "Pre-Pregnancy Checklis", NOW());

insert into parents_checklist_task(checklist_id, description, completed) values (2, "Butt out: Beyond kicking your cigarette habit, steer clear of smoky bars -- inhaling secondhand stuff is just as dangerous to a developing fetus.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (2, "Butt in: On that note, convince your partner to stop smoking. For real. Draw a line in the sand and pick a 'must-quit-by' date.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (2, "Party less hard: Research shows that heavy drinkers may have a harder time conceiving than sometime sippers.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (2, "Take to the treadmill: Moderate exercise will keep you and baby healthy during pregnancy.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (2, "Step on the scale: Women who weigh too much or too little may trouble conceiving", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (2, "Kick your latte habit: Drinking three or more cups of coffee a day may raise your miscarriage risk.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (2, "Make sure your daily multivitamin is the prenatal kind. The extra-large dose of folic acid helps baby's nervous system develop properly.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (2, "Give up birth control a few months before you want to start trying so you can determine when you ovulate (the short window of time when you can actually get pregnant).", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (2, "Find an ob-gyn you love: Ask friends for recommendations. (Don't mention the 'ob' part if you're keeping your plans a secret.)", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (2, "Make a date: A head-to-toe check-up will reveal any conditions that may impact your pregnancy, from diabetes to chlamydia.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (2, "Tote your meds: Have your doc review all prescriptions and OTC drugs, and suggest alternatives if any are not safe.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (2, "Boost your immunity: Ask your doctor if all your vaccines are up-to-date. Many are unsafe to receive once you're expecting.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (2, "Get molecular: If you've never been tested for genetic disorders, consider whether this is right for you.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (2, "Visit the dentist: Pregnancy hormonal changes make many gals prone to gingivitis. Learn whether you need to beef up your oral hygiene routine.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (2, "Call your insurance provider: Get the full rundown on how the company handles prenatal care. You may need to opt for an in-network MD or choose a specific hospital.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (2, "Phone a financial planner: It's always a good idea to chat with a pro about childcare or other expenses you anticipate.", 0);
insert into parents_checklist_task(checklist_id, description, completed) values (2, "Ponder your post-baby work plans: If one of you may make a career change, you'll want to start planning now.", 0);

ALTER TABLE parents_user AUTO_INCREMENT = 0;
ALTER TABLE parents_checklist AUTO_INCREMENT = 0;
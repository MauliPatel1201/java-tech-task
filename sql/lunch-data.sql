CREATE TABLE ingredient (
	ingredient_id  int unsigned auto_increment primary key,
    TITLE VARCHAR(256) NOT NULL,
    BEST_BEFORE DATE DEFAULT NULL,
    USE_BY DATE DEFAULT NULL
);

INSERT INTO ingredient (TITLE, BEST_BEFORE, USE_BY) VALUES
    ('Ham','2030-12-31','2030-01-01'),
    ('Cheese','1999-01-01','2030-01-01'),
    ('Bread','2030-12-31','2030-01-01'),
    ('Butter','2030-12-31','2030-01-01'),
    ('Bacon','2030-12-31','2030-01-01'),
    ('Eggs','2030-12-31','2030-01-01'),
    ('Baked Beans','2030-12-31','2030-01-01'),
    ('Mushrooms','2030-12-31','2030-01-01'),
    ('Sausage','2030-12-31','2030-01-01'),
    ('Hotdog Bun','2030-12-31','2030-01-01'),
    ('Ketchup','2030-12-31','2030-01-01'),
    ('Mustard','2030-12-31','2030-01-01'),
    ('Lettuce','2030-12-31','2030-01-01'),
    ('Tomato','2030-12-31','2030-01-01'),
    ('Cucumber','2030-12-31','2030-01-01'),
    ('Beetroot','2030-12-31','2030-01-01'),
    ('Salad Dressing','2030-12-31','1999-01-01'),
    ('Spinach','2030-12-31','1999-01-01'),
    ('Milk','2030-12-31','1999-01-01');

CREATE TABLE recipe (
	 recipe_id int unsigned auto_increment primary key,
     TITLE VARCHAR(256) NOT NULL);

INSERT INTO recipe (title) VALUES
    ('Ham and Cheese Toastie'),
    ('Fry-up'),
    ('Salad'),
    ('Hotdog'),
    ('Omelette')
;

CREATE TABLE recipe_ingredient (
	id int unsigned auto_increment,
    recipe_id int unsigned NOT NULL,
    ingredient_id int unsigned  NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_recipe_id FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id),
    CONSTRAINT FK_ingredient_id FOREIGN KEY (ingredient_id) REFERENCES ingredient (ingredient_id)
);

INSERT INTO recipe_ingredient (recipe_id, ingredient_id) VALUES
   (1,1),
    (1,2),
    (1,3),
    (1,4),

    (2,5),
    (2,6),
    (2,7),
    (2,8),
    (2,9),
    (2,3),

    (3,13),
    (3,14),
    (3,15),
    (3,16),
    (3,17),

    (4, 10),
    (4,9),
    (4,11),
    (4,12),

    (5,6),
    (5,8),
    (5,19),
    (5,18)
;


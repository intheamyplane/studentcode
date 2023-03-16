BEGIN TRANSACTION;

DROP TABLE IF EXISTS recipe_plant, recipe, plant_location, location, plant CASCADE;

CREATE TABLE plant(
	plant_id serial NOT NULL,
	plant_name varchar (200) UNIQUE NOT NULL,
	scientific_name varchar (200) NULL,
	description varchar (20000) NULL,
	CONSTRAINT PK_plant PRIMARY KEY (plant_id)
);

CREATE TABLE location(
	location_id serial NOT NULL,
	location_name varchar (200) UNIQUE NOT NULL,
	address varchar (200) UNIQUE NOT NULL,
	CONSTRAINT PK_location PRIMARY KEY (location_id)
);

CREATE TABLE plant_location(
	plant_id int NOT NULL,
	location_id int NOT NULL,
	CONSTRAINT PK_plant_location PRIMARY KEY (plant_id, location_id),
	CONSTRAINT FK_plant_location_plant FOREIGN KEY (plant_id) REFERENCES plant(plant_id),
	CONSTRAINT FK_plant_location_location FOREIGN KEY (location_id) REFERENCES location(location_id)
);

CREATE TABLE recipe(
	recipe_id serial NOT NULL,
	recipe_name varchar (200) UNIQUE NOT NULL,
	ingredients varchar (20000) NULL,
	description varchar (50000) NULL,
	CONSTRAINT PK_recipe PRIMARY KEY (recipe_id)
);

CREATE TABLE recipe_plant(
	recipe_id int NOT NULL,
	plant_id int NOT NULL,
	CONSTRAINT PK_recipe_plant PRIMARY KEY (recipe_id, plant_id),
	CONSTRAINT FK_recipe_plant_recipe FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id),
	CONSTRAINT FK_recipe_plant_plant FOREIGN KEY (plant_id) REFERENCES plant(plant_id)
);


INSERT INTO plant (plant_name, scientific_name, description)
VALUES ('Curly dock', 'Rumex crispus', 'Invasive edible common in N. America from the buckwheat family. High in oxalic acid, but cooking can help with bitterness. Leaves are good to eat young and stems are good to eat before flowers blossom. Rich in vitamin A and C'),
		('Mugwort', 'Artemisia vulgaris', 'Medicinal herb that smells similar to sage. Contains healthful flavenoids and has been used to aid digestion, menstruation and circulation. Can cause vivid dreams and was reportedly smoked by indignenous groups for this purpose'),
		('Pawpaw', 'Asimina triloba', 'Largest edible fruit indigenous to the United States. Custard-like texture and flavor similar to banana'),
		('Dead nettle', 'Lamium purpureum', 'Common early spring weed in the mint family. Abundant in vitamins, particularly vitamin C, along with iron, fiber and quercetin, while the oil in its seeds is packed with powerful antioxidants.');

INSERT INTO location (location_name, address)
VALUES ('Home', '3312 Montana Ave Cincinnati, OH 45241'),
		('Mt Airy Forest', '5083 Colerain Ave Cincinnati, OH 45223');

INSERT INTO plant_location (plant_id, location_id)
VALUES		
	(
	(SELECT plant_id FROM plant WHERE plant_name = 'Curly dock'), (SELECT location_id FROM location WHERE location_name = 'Home')
	),
	(
	(SELECT plant_id FROM plant WHERE plant_name = 'Mugwort'), (SELECT location_id FROM location WHERE location_name = 'Home')
	),
	(
	(SELECT plant_id FROM plant WHERE plant_name = 'Pawpaw'), (SELECT location_id FROM location WHERE location_name = 'Mt Airy Forest')
	), 
	(
	(SELECT plant_id FROM plant WHERE plant_name = 'Dead nettle'), (SELECT location_id FROM location WHERE location_name = 'Home')
	);


	
INSERT INTO recipe (recipe_name, ingredients, description)
VALUES ('Mugwort rice cake (Ssuk injeolmi)', 'mugwort, glutinous (sweet) rice flour, roasted soybean powder (konggaru), kosher salt, sugar', '1) Place 1 cup of sweet rice flour, blanched mugwort (grind w/food processor), 1/4 ts kosher salt, 1 tbs sugar, and 3/4 cup water in a microwavable bowl. Mix well to make dough. 
		2) Cover w/Saran wrap and microwave for 3 min. 
		3) Mix the hot dough w/wooden spoon for 20 seconds, wrap, microwave for 1 more minute.
		4) Transfer dough into a mortar and pound for 1 min. The sound of bubbles popping indicates proper consistency. 
		5) Spread 1/2 cup roasted soybean powder onto cutting board. Cut rice cake into bite size pieces and coat with powder'),
		
		('Wild pesto', 'Wild greens (dead nettle, chickweed, wood sorrel, dandelion, purslane, lambs quarter), garlic, lemon zest, pine nuts, extra virgin olive oil, salt, pepper', '1) Rinse, drain and pat dry your foraged weeds.
		2) In the bowl of a food processor, quickly pulse 3 cloves garlic and 1/4 cup pine nuts to a rough meal.
		3) Add 4 cups foraged weeds and zest of one lemon to food processor and pulse until well combined.
		4) While food processor is running, slowly pour in 2/3 cup olive oil until desired consistency is reached. Salt and pepper to taste.
		5) Serve with desired dish or freeze until needed.');

INSERT INTO recipe_plant (recipe_id, plant_id)
VALUES		
	(
	(SELECT recipe_id FROM recipe WHERE recipe_name = 'Mugwort rice cake (Ssuk injeolmi)'),(SELECT plant_id FROM plant WHERE plant_name = 'Mugwort')
	),
	(
	(SELECT recipe_id FROM recipe WHERE recipe_name = 'Wild pesto'),(SELECT plant_id FROM plant WHERE plant_name = 'Dead nettle')
	);




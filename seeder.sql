USE blog_db;

INSERT INTO posts (date, title, description, body, slug, user_id)
VALUES ('August 2020', 'Raising the Bar',
        'Up, up and away… our new Poolside Provisions vintage truck took to the air,
        soaring(carefully) three stories to be installed beside the rooftop pool.',
        'It’s the culmination of an 18-month design and renovation feat that’s given a 1960s-era Pearl beer truck new life as a poolside bar,
        geared up to satisfy our guests’ al fresco cravings for food and drink,
        once it’s opened for business in March.',
        '#', 1),
            ('April 2020', 'Dining Out',
        'Our Chef John Brand created a feast in a Peeler Farms pasture. He and his crew cooked al fresco for 130 guests of Marianne and Jason Peeler, hosts of the sold-out “Outstanding in the Field” event in mid-October.'',
        ''It’s the culmination of an 18-month design and renovation feat that’s given a 1960s-era Pearl beer truck new life as a poolside bar, geared up to satisfy our guests’ al fresco cravings for food and drink, once it’s opened for business in March.',
        'John knows the Peelers from way back — they’ve supplied Supper with lamb and Wagyu beef since 2015. This was the second Brand-Peeler collaboration to provide guests with a dining experience that literally brings them back to the land. The extensive menu featured Peeler Farms Wagyu tenderloin and sirloin, plus dishes using Texas-sourced ingredients from nearly 25 farms, ranches, dairies, orchards, mills and apiaries. Wine and spirits also originated in Texas, as did the ice-cold Pearl beer.
“Outstanding in the Field” began in California 20 years ago to showcase local farms and ranches. The feasts always feature a single, elegantly-appointed table, locally-sourced ingredients and a guest chef. OITF events have taken place in all 50 US states and in 15 international locations.
', '#', 1),
       ('February 2020','Doing Time', 'He may have developed the patience to make the hours-long desert exposures right here at Hotel Emma and the Pearl. For four years during renovation, Scott roamed the construction site, setting up eight cameras to capture over 400,000 still images of an abandoned brewery complex becoming a dynamic destination and neighborhood.',
        '
Scott Martin on the Pearl construction site

What do you like best about shooting Hotel Emma?
Lots of things… The camaraderie with the construction workers and planners. The site was so unusual that we had to figure out a lot of things as we went. Everyone watched out for each other — strangers helping strangers. The morale was high, along with a feeling that we were all involved with making something of significance. For the most part, that job site was incredibly quiet and serene at night. It was a peaceful, dark, electricity-free pocket within a bustling city. It was a dream-like place to work at night all by myself. There were times were I worked constantly for 2-4 days straight without leaving the site. I would scout by day and shoot all night, taking short naps during long exposures. Tripod, camera bag and kitchen bag. That seems to be the process wherever I go.

When I started this work there was no Hotel Emma or even a concept of what the building might become. It’s fun to look at some of those early photos now and compare them to the places that they have become. I didn’t realize at the time that I was taking photos of what would later be the Emma Koehler and Maritzen suites, library and lobby. So those before and after photos in the same places show the drama of Hotel Emma’s transformation.

What’s your favorite Hotel Emma “discovery?”
All of the cellars buildings were refrigerated at lagering temperature (34°F - 45°F) for their entire lifespan. The buildings were lined with 6 to 12 inches of cork insulation and the cellarmen wore wool suits while working. Ammonia was used as the refrigerant and its flow was controlled from a single manifold you can see today in the lobby at the Sternwirth entrance. Every time I see that ammonia manifold I think about those guys in wool suits.

How old were you when you decided to be a photographer?
I asked for a camera when I was 5 years old and would wander the neighborhood hunting for photos, trying to be smart about using those 12 frames wisely. My interest in photography as art has grown steadily since then. The hunt for the image and experimentation with process remains a big draw.', '#',1 ),
       ('October 2019','Grateful to the Dead',
        'We join many San Antonians and friends and family south of the border in honoring our Dear Departed with a Dia de los Muertos (Day of the Dead) altar. Ours welcomes namesake Emma Koehler back to the brewery she ran very successfully from 1914 to 1942.',
        'This heartfelt custom had its beginnings in pre-Columbian Mesoamerica, took on Christian symbolism when Europeans arrived and has now become a nearly-mainstream celebration across the U.S. Dia de los Muertos is the day spirits of loved ones return to us. It is celebrated on November 1 (Dia de los Angelitos) when the souls of children are revered and on November 2, when adult spirits are honored.
O death, where is thy sting? Countered and cured with a respectful altar filled with color, mischief, and memories. The altar’s furnishings are ofrendas (offerings), symbols of life and death, plus a healthy dose of macabre humor to lessen the sting.
Day of the Dead skeleton figures
Calaveras and calacas. Skulls, bones and skeletons rendered in papier maché, ceramic, sugar and pastel icing. These symbols of death are a holdover from the Aztecs, who considered death the beginning of new life.
La Catarina. Jose Guadalupe Posada, renowned Mexican illustrator/lithographer of the early 20th century, created this elaborately costumed skeleton, which satirizes the politics of the time and portrays the equalizing effect of death on rich and poor alike.
Day of the Dead skeleton drawing
Cockscomb/Terciopelo Rojo. Velvety and convoluted, the red variety of this eccentric-looking bloom was once connected to the Aztec war god, Huitzilopochtli. Spanish missionaries appropriated it as the sacrificial Blood of The Lamb.
Cross covered in purple and orange flowers
Papel Picado. Colorful, intricate tissue paper banners are said to wave and flutter when the spirits are present.
Votive candles. Each flame represents a departed soul and lights the way for their return.
Dogs. Our best friends in life and our guides in the afterlife.
Copal incense. Since the days of the Aztecs, believers have burned this fragrant tree resin. The scent and smoke carry prayers heavenward.
Pan de Muertos. Bread of the Dead. Traditional sweet bread decorated with symbolic bones and a teardrop in the center.
Water. The elemental liquid quenches the spirits’ thirst after their long journey.
Salt. Purifies and protects the spirits.
Beer. The spirits are offered their favorite beverages — beer, tequila, whiskey, rum, pulque — whatever they liked to imbibe in life.
The Aztecs believed that mourning the dead with tears would make the spirits’ path slippery and difficult to travel, so they honored loved ones with joy. With Emma’s altar, we carry on a 3,000-year tradition of remembering and welcoming.',
        '#', 1),
       ('September 2019','What Emma and Otto Bring to the Table',
        'View the video for more about Walsh’s thinking behind the allusions, symbolism and artifacts in the paintings, destined to hang in Supper’s dining room.
',
        'Painter Lloyd Walsh is well-known in San Antonio’s art community (and beyond) for his idiosyncratic and beautiful work. Recently, he accepted a commission from us to paint portraits of Otto and Emma Koehler. Lloyd suggested that he represent the two Pearl titans as still-life paintings of tables, set with dishes, food and drink that reflects each founder’s history and personality. We loved the idea.

View the video for more about Walsh’s thinking behind the allusions, symbolism and artifacts in the paintings, destined to hang in Supper’s dining room.',
        '#',1)
;

INSERT INTO users (email, password, username) VALUES ('alexa@me.com', 'alexa', 'alexa');

INSERT INTO users (email, password, username) VALUES ('lucy@me.com', 'lucy', 'lucy');

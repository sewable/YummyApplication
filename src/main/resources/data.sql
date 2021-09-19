INSERT INTO `user`(username, password, role)
VALUES ('admin1', 'Admin1_123', 'ADMIN'),
       ('user1', 'User1_123', 'USER'),
       ('user2', 'User2_123', 'USER')
;

INSERT INTO post(id, title, photo, content, user_username)
VALUES (1, 'Chorizo & mozzarella gnocchi bake',
        'gnocchi-1d16725.png',
        'STEP 1 <br/><br/>
        Heat the oil in a medium pan over a medium heat. Fry the onion and garlic for 8-10 mins until soft. Add the chorizo and fry for 5 mins more. Tip in the tomatoes and sugar, and season. Bring to a simmer, then add the gnocchi and cook for 8 mins, stirring often, until soft. Heat the grill to high.
        <br/><br/><br/>
        STEP 2 <br/><br/>
        Stir ¾ of the mozzarella and most of the basil through the gnocchi. Divide the mixture between six ovenproof ramekins, or put in one baking dish. Top with the remaining mozzarella, then grill for 3 mins, or until the cheese is melted and golden. Season, scatter over the remaining basil and serve with green salad.',
        'admin1'),
       (2, 'Easy classic lasagne',
        'classic-lasange-4a66137.png',
        'STEP 1 <br/><br/>
        Heat the oil in a large saucepan. Use kitchen scissors to snip the bacon into small pieces, or use a sharp knife to chop it on a chopping board. Add the bacon to the pan and cook for just a few mins until starting to turn golden. Add the onion, celery and carrot, and cook over a medium heat for 5 mins, stirring occasionally, until softened.
        <br/><br/><br/>
        STEP 2 <br/><br/>
        Add the garlic and cook for 1 min, then tip in the mince and cook, stirring and breaking it up with a wooden spoon, for about 6 mins until browned all over.
        <br/><br/><br/>
        STEP 3 <br/><br/>
        Stir in the tomato purée and cook for 1 min, mixing in well with the beef and vegetables. Tip in the chopped tomatoes. Fill each can half full with water to rinse out any tomatoes left in the can, and add to the pan. Add the honey and season to taste. Simmer for 20 mins.
        <br/><br/><br/>
        STEP 4 <br/><br/>
        Heat oven to 200C/180C fan/gas 6. To assemble the lasagne, ladle a little of the ragu sauce into the bottom of the roasting tin or casserole dish, spreading the sauce all over the base. Place 2 sheets of lasagne on top of the sauce overlapping to make it fit, then repeat with more sauce and another layer of pasta. Repeat with a further 2 layers of sauce and pasta, finishing with a layer of pasta.
        <br/><br/><br/>
        STEP 5 <br/><br/>
        Put the crème fraîche in a bowl and mix with 2 tbsp water to loosen it and make a smooth pourable sauce. Pour this over the top of the pasta, then top with the mozzarella. Sprinkle Parmesan over the top and bake for 25–30 mins until golden and bubbling. Serve scattered with basil, if you like.',
        'user1'),
       (3, 'Easy carrot cake',
        'carrot-cake-f1b3d0c.png',
        'STEP 1 <br/><br/>
        Heat the oven to 180C/160C fan/gas 4. Oil and line the base and sides of two 20cm cake tins with baking parchment. Whisk the oil, yogurt, eggs, vanilla and zest in a jug. Mix the flour, sugar, cinnamon and nutmeg with a good pinch of salt in a bowl. Squeeze any lumps of sugar through your fingers, shaking the bowl a few times to bring the lumps to the surface.
        <br/><br/><br/>
        STEP 2 <br/><br/>
        Add the wet ingredients to the dry, along with the carrots, raisins and half the nuts, if using. Mix well to combine, then divide between the tins.
        <br/><br/><br/>
        STEP 3 <br/><br/>
        Bake for 25-30 mins or until a skewer inserted into the centre of the cake comes out clean. If any wet mixture clings to the skewer, return to the oven for 5 mins, then check again. Leave to cool in the tins.
        <br/><br/><br/>
        STEP 4 <br/><br/>
        To make the icing, beat the butter and sugar together until smooth. Add half the soft cheese and beat again, then add the rest (adding it bit by bit prevents the icing from splitting). Remove the cakes from the tins and sandwich together with half the icing. Top with the remaining icing and scatter with the remaining walnuts. Will keep in the fridge for up to five days. Best eaten at room temperature.',
        'user2')
;

INSERT INTO ingredients(id, post_id, value)
VALUES (1, 1, '1 tbsp olive oil'),
       (2, 1, '1 onion , finely chopped'),
       (3, 1, '2 garlic cloves , crushed'),
       (4, 1, '120g chorizo , diced'),
       (5, 1, '2 x 400g cans chopped tomatoes'),
       (6, 1, '1 tsp caster sugar'),
       (7, 1, '600g fresh gnocchi'),
       (8, 1, '125g mozzarella ball, cut into chunks'),
       (9, 1, 'small bunch of basil , torn'),
       (10, 1, 'green salad , to serve'),

       (11, 2, '1 tbsp olive oil'),
       (12, 2, '2 rashers smoked streaky bacon'),
       (13, 2, '1 onion , finely chopped'),
       (14, 2, '1 celery stick, finely chopped'),
       (15, 2, '1 medium carrot , grated'),
       (16, 2, '2 garlic cloves , finely chopped'),
       (17, 2, '500g beef mince'),
       (18, 2, '1 tbsp tomato purée'),
       (19, 2, '2 x 400g cans chopped tomatoes'),
       (20, 2, '1 tbsp clear honey'),
       (21, 2, '500g pack fresh egg lasagne sheets'),
       (22, 2, '400ml crème fraîche'),
       (23, 2, '125g ball mozzarella , roughly torn'),
       (24, 2, '50g freshly grated parmesan'),
       (25, 2, 'large handful basil leaves , torn (optional)'),

       (26, 3, '230ml vegetable oil, plus extra for the tin'),
       (27, 3, '100g natural yogurt'),
       (28, 3, '4 large eggs'),
       (29, 3, '1½ tsp vanilla extract'),
       (30, 3, '½ orange, zested'),
       (31, 3, '265g self-raising flour'),
       (32, 3, '335g light muscovado sugar'),
       (33, 3, '2½ tsp ground cinnamon'),
       (34, 3, '¼ fresh nutmeg, finely grated'),
       (35, 3, '265g carrots (about 3), grated'),
       (36, 3, '100g sultanas or raisins'),
       (37, 3, '100g walnuts or pecans, roughly chopped (optional)'),
       (38, 3, '100g slightly salted butter, softened'),
       (39, 3, '300g icing sugar'),
       (40, 3, '100g soft cheese')
;

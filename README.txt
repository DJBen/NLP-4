nlp assignment 4

Problem 1

Note: The parser we are using is the Stanford one.

(a) Was there anything interesting or surprising about the style of trees produced by the parser?

Solution:
We find the following interesting or surprising facts:
1. The parser has a very rich collection of nonterminals. For example, adjective also has categories for comparative and superlative adjectives. A what phrase also has categories like wh-adjective phrase, wh-adverb phrase, wh-noun phrase, wh-prepositional phrase. Sometimes even the single word "to" is put into single category called "TO".

2. Punctuation is also handled in the parser.

3. The Stanford parser can also handle languages like Chinese and Arabic.

4. The parser can also parse phrase, not just any complete sentence.



(b) What were some things that the parser got wrong? What were some hard things that it managed to get right?

Solution:
The parser seems having trouble to get it correct on some short sentence. For example, we tried "Hurry up!", which was parsed by the parser as a fragment with two adverbs. However the word "Hurry" here should be a verb. Also we tried similar sentences like "Awesome!", "Excellent!", "Great!", which were all parsed as noun or verb, but not adjective.
Also the parser is still not perfect when getting sentences with ambiguity. Just took the exmaple from class, "Time flies like an arrow.". The parser can get this one right. But if we change the sentence to "Time those flies with this watch.", it still parsed in the way that "flies" is considered as a verb, which is not right for this sentence.
For some sentences like "We watched football at home.", "We sing a song in the classroom.", the parser will put the PP "at home" and "in the classroom" to describe "football" and "song". But actually they shall be used to describe "We" in both sentences.

To parse a sentence with clause, especially without a conjunction, may be hard. But the parser did it well with several sentences that I tried, like "I saw you did it.", "I watch you drink it.". 

(c) Can you stump it with a grammatical sentence that you make up? With a grammatical sentence that you find in an online document?

Solution:
I made up a relatively easy sentence: "I bought Lily some perfume." But the parser didn't parse it correctly, where Lily was mistaken by it as a verb.

I found a sentence from the novel The Great Gatsby: "And as I walked on I was lonely no longer." The parser mistook it by putting "on I" as PP.



Problem 1 extra credit
Solution: We played with the TurboParser, which is a parser can print the dependency relation between different words in the sentence. So I just tried several sentences to test its accuracy on the dependency relation.

I think telling which noun that a preposition phrase is depending on can be tricky. I tried the sentence "The pen on the table is mine.", which was parsed correctly. But for the sentence "I took the pen on the table.", it can not tell "on the table" is a PP for "the pen". And for some tricky sentence like "In God we trust.", it can actually get it right.

I also tried sentences with ambiguity. The one "Time flies like an arrow." can be parsed correctly. But when I changed it to "Time the car with this watch", it couldn't parse it anymore.

For long sentences with clauses, the parser functions very well on sentences without conjuntions, like "I watched you ate it." and "I saw you did it.". But for the sentence I picked from The Great Gatsby, "As I walked on I was lonely no longer", it made the same mistake as the Stanford parser, which took "on I" as a PP.


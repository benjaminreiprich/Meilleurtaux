# Meilleurtaux

Voici ma réponse au petit test technique à savoir :

Objectif du test :

Faire une API REST prenant en entrée un code postal et retournant son/ses noms de commune et sa population uniquement.

Avec les caractéristiques suivantes : Utiliser en Spring Boot 3

Utiliser l'API du gouvernement pour obtenir la/les communes : https://geo.api.gouv.fr/decoupage-administratif/communes

Gestion d'erreurs et code retours

Je me permets d’apporter tout de même quelques précisions sur le code écrit. J’ai fait volontairement le choix de ne pas partir sur une architecture classique et d’utiliser plusieurs couches ( Controller, Service, Modèle) vu la complexité du problème. J’ai bien évidemment conscience que ce n’est absolument pas la bonne manière de procéder dans le cas d’un réel développement. J’ai également déclaré les objets directement dans la méthode et je n’ai pas utilisé l’autowired de spring même si j’aurais pû. J’ai enfin fait le choix également de ne pas implémenter d’exception handler (qui évite la redondance des catch d’erreurs dans les controller et laisse Spring gérer tout ça) vu la complexité du problème encore une fois.

N’hésite pas à revenir vers moi si tu veux que j’implémente tout ça (les différentes couches, l’handler d’exception, l’autowiring des beans) et si tu veux également que j’implémente les tests.

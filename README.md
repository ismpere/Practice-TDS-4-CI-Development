*** Práctica realizada por Ismael Pérez Martín ***
	
	Tiempo total empleado en la realización de la práctica: 20h 16m
	

	Clases que forman parte de la solución del proyecto:

    (main)
		Persona------------------------------------ SLOC:324  LLOC:176
		ColaDeAmigos------------------------------- SLOC:202  LLOC:111 
		

	(test)
		ColaDeAmigosBlackBoxIsolationTest---------- SLOC:535   LLOC:531 
		PersonaBlackBoxTest------------------------ SLOC:503   LLOC:499 
		ColaDeAmigosBlackBoxIntegrationTest-------- SLOC:332   LLOC:328 
		ColaDeAmigosBlackBoxUnitTest--------------- SLOC:220   LLOC:216 
		PersonaTDDTest----------------------------- SLOC:216   LLOC:212 
		ColaDeAmigosIsolationTDDTest--------------- SLOC:181   LLOC:177 
		ColaDeAmigosIntegrationTDDTest------------- SLOC:112   LLOC:108 	
		PersonaSecuenceTest------------------------ SLOC:99    LLOC:95 	
		ColaDeAmigosSecuenceTest------------------- SLOC:94    LLOC:90 
		ColaDeAmigosConAmigosYColadosTest---------- SLOC:82    LLOC:78 
		ColaDeAmigosUnitTDDTest-------------------- SLOC:68    LLOC:64 
		PersonaTieneReservasTest------------------- SLOC:47    LLOC:43 
		ColaDeAmigosAllTest------------------------ SLOC:20    LLOC:16 
		PersonaAllTest----------------------------- SLOC:16    LLOC:12 
		AllTest------------------------------------ SLOC:14    LLOC:10 
		Unit--------------------------------------- SLOC:7     LLOC:3
		Secuence----------------------------------- SLOC:7     LLOC:3 
		Integration-------------------------------- SLOC:7     LLOC:3 
		TDD---------------------------------------- SLOC:7     LLOC:3 
		Isolation---------------------------------- SLOC:7     LLOC:3  
		
	(test de cada clase)
		Persona------------------------------------ SLOC:881   LLOC:861
		ColaDeAmigos------------------------------- SLOC:1644  LLOC:1608


*** Aclaración sobre el coverage ***

En EclEmma conseguía casi el 100% de cobertura, pero siempre tenía el mismo problema, 
había una rama que no se cubría por los test. (1 of 4 branches misses).

Tras buscar por internet, la única opcion que he encontrado es que esa cuarta rama, se ejcuta con los test desactivados.
Esto lo he podido comprobar ya que hacíendo una rama de prueba, sustituyendo los asertos por excepciones controladas por if, se consegúia el 100% de cobertura en esa rama.

Esto hace que baje la cobertura también en SonarQube, cuando en realidad ramas tan sencillas como comprobar que es nulo, siempre deja una rama sin cubrir.

 
 

*** Aclaración sobre los test de aislamiento ***

Según el criterio que he usado, si usa algún método de otro objeto, el test es de aislamiento, pero para casos como el constructor, solo he considerado que es de aislamiento
en su caso más básico, ya que sinó por esa misma regla, prácticamente todos los test de ColaDeAmigos serían de aislamiento.

 
 

*** Aclaración sobre el refactor ***

Al tener la herramienta SonarLint instalada en Eclipse, al llegar al ciclo de Refactor, la grán mayoría de errores estaban solucionados, al igual que los 
code smells, ya que directamente me avisaba en azul cuando hacía algo mal, asique he llegado a ese ciclo sin code smells ni bugs.

Los refactor que he hecho fuera están tambiñen mencionados en el issue eliminar code smells y do refactor, pero en concreto son:

Sustituir el método contains y remove de ArrayList, sobreescribir hashCode por haber sobreescrito equals, sustituir Persona p[] por Persona[] p, y eliminar variables
que no usaba o imports no usados. También lo he usado para sustituir alguna condición booleana por una versión más simple.

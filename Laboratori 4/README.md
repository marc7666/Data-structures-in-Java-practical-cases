# Laboratori-4-EEDD

## Implementació dels mètodes:

### void add(V value, P priority):

Després de crear un Triplet amb els paràmetres de la funció i el timeStamp corresponent, afegeix el Triplet al final de l'ArrayList i incrementa el timeStamp per cada operació d'inserció i extracció que fa. Això servirà per diferenciar les prioritats iguals.

A partir de l'últim element va comprovant que tingui pare i que sigui de prioritat inferior. Per comparar dos Triplet utilitza el mètode compareTo (expliucat més endavant). En cas de ser superior, s'intercanviaràn.

Per fer aquest intercanvi, utilitza un mètode auxiliar anomenat swap.

Cal observar qye el compareTo compara dues instàncies de Triplet. Per a que pugui realitzar bé la comparació, també implementa un altre mètode auxiliar anomenat getParent, amb un funcionament idèntic al màtode estàtic parent ja donat, però en comptes de retornar l'índex del pare, retorna el Triplet del pare.

### V remove():

....

### V element():

Tracta l'excepció i retorna el valor corresponent V del primer Triplet de l'ArrayList (posició 1). Aquest mètode no cal que garanteixi que sigui max-heap, d'això se'n asseguren els mètodes d'inserció i extracció.

### int size():

Retorna el nombre d'elements de l'ArrayList. Utilitza el mètode size() ja implementat.

El fet de restar 1 en el valor de retorn, és degut a que la primera posició de l'ArrayList no s'utilitza. Degut al seu desus, s'ha près la decissió de disseny d'establir la posició amb índex 0 de l'ArrayList amb un valor i una prioritat igual a null.

### int compareTo(Triplet<V, P> o):

1) Tracta el cas de les prioritats null. Si una prioritat és null, l'altra per força serà superior (i viceversa).
2) Compara prioritats diferents amb el mètode equals.
3) Compara prioritats iguals i tracta els timeStamp de cada Triplet. Retornarà el timeStamp de menys valor, és a dir, el que ha arribat primer.

## Tests:

S'ha implementat una classe de test per cada tipus de test, és a dir, s'ha implementat una classe per els tests del add(), una per als tests del remove(), una per als tests del element() i una per als tests del size().

### Tests add():

Per al test del add(), s'han realitzat els casos explicats en el compareTo, per comprovar que aquest últim funciona correctament. S'ha afegit una comparació de prioritat null amb una altra prioritat null.

A més, al apartat 1) del compareTo, s'ha afegit un test amb prioritats desordenades per corroborar que el mètode add reordena correctament.

### Tests remove():

.....

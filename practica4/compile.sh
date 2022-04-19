#!/bin/bash
# @author: Hector Gonzalez Iglesias

for i in ImpuestosCirculacionCommon ImpuestosCirculacionDAO ImpuestosCirculacionBusiness ImpuestosCirculacionGUI ImpuestosCirculacionMain ImpuestosCirculacionRellena
do
	cd $i/
	mvn compile
	mvn install
	cd ..
done

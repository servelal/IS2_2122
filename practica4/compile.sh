#!/bin/bash
# @author: Hector Gonzalez Iglesias

for i in ImpuestosCirculacionCommon ImpuestosCirculacionDAO ImpuestosCirculacionBusiness ImpuestosCirculacionGUI ImpuestosCirculacionMain ImpuestosCirculacionRellena
do
	cd $i/
	mvn clean compile
	mvn clean install
	cd ..
done

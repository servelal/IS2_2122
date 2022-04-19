#!/bin/bash
# @author Hector Gonzalez Iglesias
# Script (para linux) que automaticamente compila e instala los artefactos necesitados

for i in ImpuestosCirculacionCommon ImpuestosCirculacionDAO ImpuestosCirculacionBusiness ImpuestosCirculacionGUI ImpuestosCirculacionMain ImpuestosCirculacionRellena
do
	cd $i/
	mvn compile
	mvn install
	cd ..
done

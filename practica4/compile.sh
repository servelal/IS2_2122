#!/bin/bash
# @author Hector Gonzalez Iglesias
# Script (para linux) que automaticamente compila e instala los artefactos necesitados en orden

for i in ImpuestosCirculacionCommon ImpuestosCirculacionDAO ImpuestosCirculacionBusiness ImpuestosCirculacionGUI ImpuestosCirculacionMain ImpuestosCirculacionRellena ListaAcotada
do
	cd $i/
	mvn clean validate
	mvn clean compile
	mvn clean install
	mvn clean package
	cd ..
done

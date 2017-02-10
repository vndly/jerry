#!/bin/bash

dir="/home/mauricio/jerry"
tmp="$dir/tmp"

clone_url="https://github.com/vndly/jerry.git"

fetch() {
	if [ -d "$tmp" ]; then
		if [ -d "$tmp/.git" ]; then
			echo "Pulling repository..."
			cd $tmp
			git pull
		else
			echo "Cloning repository..."
			git clone "$clone_url" "$tmp"
		fi
	else
		echo "Cloning repository..."
		git clone "$clone_url" "$tmp"
	fi
}

compile() {
	echo "Compiling..."

	cd $tmp
	mvn clean compile package

	cp $tmp/target/jerry-1.0.0.jar $dir/jerry.jar
	chmod g+w $dir/jerry.jar
}

run() {
	sudo $dir/jerry.sh restart
}

fetch
compile
run
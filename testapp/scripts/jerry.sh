#!/bin/bash

dir="/home/mauricio/jerry"
pid_file="$dir/jerry.pid"
stdout_log="$dir/jerry.log"
stderr_log="$dir/jerry.err"
cmd="java -jar $dir/jerry.jar localhost"

get_pid()
{
	cat "$pid_file"
}

is_running()
{
	[ -f "$pid_file" ] && ps `get_pid` > /dev/null 2>&1
}

case "$1" in
	start)
	if is_running; then
		echo "Already started!"
	else
		echo "Starting jerry..."
		$cmd >> "$stdout_log" 2>> "$stderr_log" &
		echo $! > "$pid_file"
		if ! is_running; then
			echo "Unable to start, see $stdout_log and $stderr_log"
			exit 1
		else
			echo "Started!"
		fi
	fi
	;;
	stop)
	if is_running; then
		echo -n "Stopping jerry..."
		sudo kill `get_pid`
		for i in {1..10}
		do
			if ! is_running; then
				break
			fi

			sleep 1
		done

		if is_running; then
			echo "Not stopped, may still be shutting down or shutdown may have failed."
			exit 1
		else
			echo "Stopped!"
			if [ -f "$pid_file" ]; then
				rm -rf "$pid_file"
				rm -rf "$stdout_log"
				rm -rf "$stderr_log"
			fi
		fi
	else
		echo "Not running!"
	fi
	;;
	restart)
	$0 stop
	if is_running; then
		echo "Unable to stop, will not attempt to start"
		exit 1
	fi
	$0 start
	;;
	status)
	if is_running; then
		echo "Running!"
	else
		echo "Stopped!"
		exit 1
	fi
	;;
	*)
	echo "Usage: $0 {start|stop|restart|status}"
	exit 1
	;;
esac

exit 0
SHELL := /bin/bash
target = $(shell egrep -m 1 "^target=" project.properties | sed -n -e 's/^target=\(.*\)/\1/p')
this_dir = $(shell cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )
libs = $(shell grep 'android.library.reference' project.properties | sed -e "s/android.library.reference.*=//g")
timestamp = $(shell date +%s)

#安装本地开发环境
install:
	@for lib in $(libs); do \
		echo $$lib; \
		cp Makefile $$lib; cd $$lib; make; \
		cd $(this_dir); \
	done
	@mv build.xml build.xml-bak-$(timestamp) 2>/dev/null; android update project -p . -s -t "$(target)"; ant clean;
	@if [ -d ".git" ]; then \
		if [ -a "git-pre-commit" ]; then \
			cp git-pre-commit .git/hooks/pre-commit; \
		fi; \
	fi
review:
	@checkstyle -c checkstyle/android_checks.xml -r src

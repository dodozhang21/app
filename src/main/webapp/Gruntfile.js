'use strict'
module.exports = function(grunt) {

  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),

    clean: ['css'],
	compass: {                  // Task
	    dist: {                   // Target
	      options: {              // Target options
	        sassDir: 'sass',
	        cssDir: 'css'
	      }
	    }
	},
	watch: {
		compass: {
			files: 'sass/**/*.scss',
			tasks: ['compass', 'copy:css'],
			options: {
				spawn: false,
			},
		},
		js: {
			files: 'js/**/*.js',
			tasks: ['copy:js'],
			options: {
				spawn: false,
			},
		},
	},
	browser_sync: {
	    files: {
	        src : 'css/*.css'
	    },
        options: {
            watchTask: true,
        }
	},
	copy: {
	  css: {
		src: ['css/**/*'],
		dest: 'C:/xampp/htdocs/work/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/app/',
		filter: 'isFile',
	  },
	  js: {
		src: ['js/**/*'],
		dest: 'C:/xampp/htdocs/work/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/app/',
		filter: 'isFile',
	  },
	},
	bower: {
		install: {
			options: {
				targetDir: 'js/lib',
				cleanTargetDir: true,
				bowerOptions: {production: false}
			}
		}
	},
	jasmine: {
		appTests : {
			src: 'js/apps/*.js',
			options: {
				specs: 'js/spec/**/*Spec.js',
				//helpers: 'js/lib/*.js'
			}
		}
	}
  });


//  grunt.loadNpmTasks('grunt-contrib-concat');
//  grunt.loadNpmTasks('grunt-contrib-uglify');
	grunt.loadNpmTasks('grunt-contrib-clean');
	grunt.loadNpmTasks('grunt-contrib-compass');
	grunt.loadNpmTasks('grunt-contrib-watch');
	grunt.loadNpmTasks('grunt-browser-sync');
	grunt.loadNpmTasks('grunt-contrib-copy');
	grunt.loadNpmTasks('grunt-bower-task');
	grunt.loadNpmTasks('grunt-contrib-jasmine');
	
	//grunt.registerTask('test', ['jshint', 'qunit']);
	
	grunt.registerTask('local', ['clean', 'jasmine', 'compass', 'browser_sync', 'watch']);
	grunt.registerTask('default', ['clean', 'jasmine', 'compass']);

};
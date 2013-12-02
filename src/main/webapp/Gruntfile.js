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
	}
  });


//  grunt.loadNpmTasks('grunt-contrib-concat');
//  grunt.loadNpmTasks('grunt-contrib-uglify');
	grunt.loadNpmTasks('grunt-contrib-clean');
	grunt.loadNpmTasks('grunt-contrib-compass');
	grunt.loadNpmTasks('grunt-contrib-watch');
	grunt.loadNpmTasks('grunt-browser-sync');
	grunt.loadNpmTasks('grunt-contrib-copy');
	
	//grunt.registerTask('test', ['jshint', 'qunit']);
	
	grunt.registerTask('default', ['clean', 'compass', 'browser_sync', 'watch']);

};
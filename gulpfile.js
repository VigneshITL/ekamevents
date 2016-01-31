// gulp
var gulp = require('gulp');

// plugins
var jshint = require('gulp-jshint');
var uglify = require('gulp-uglify');
var minifyCSS = require('gulp-minify-css');
var clean = require('gulp-clean');
var runSequence = require('run-sequence');
var rimraf = require('rimraf');
var watch = require('gulp-watch');
var gutil = require('gulp-util');

// tasks
gulp.task('lint', function() {
	gulp.src(['./frontend/app/**/*.js', '!./frontend/app/bower_components/**'])
		.pipe(jshint())
		.pipe(jshint.reporter('default'))
		.pipe(jshint.reporter('fail'));
});
gulp.task('clean', function(cb) {
	rimraf('./public/**/*', cb);
});
gulp.task('minify-css', function() {
	var opts = {comments:true,spare:true};
	gulp.src(['./frontend/app/**/*.css', '!./frontend/app/bower_components/**'])
		.pipe(minifyCSS(opts))
		.pipe(gulp.dest('./public/'))
});
gulp.task('minify-js', function() {
	gulp.src(['./frontend/app/**/*.js', '!./frontend/app/bower_components/**'])
		.pipe(uglify({
			// inSourceMap:
			// outSourceMap: "app.js.map"
		}))
		.pipe(gulp.dest('./public/'))
});
gulp.task('copy-bower-components', function () {
	gulp.src('./frontend/app/bower_components/**')
		.pipe(gulp.dest('public/bower_components'));
});
gulp.task('copy-html-files', function () {
	gulp.src('./frontend/app/**/*.html')
		.pipe(gulp.dest('public/'));
});
var source = './frontend/app',
		destination = './public';

gulp.task('watch', function() {
	gulp.src(['./frontend/app/**/*.js',  './frontend/app/**/*.css', '!./frontend/app/bower_components/**'])
			.pipe(watch(['./frontend/app/**/*.js',  './frontend/app/**/*.css', '!./frontend/app/bower_components/**']))
			.pipe(jshint())
			.pipe(jshint.reporter('default'))
			.pipe(gulp.dest(destination));
	gulp.src('./frontend/app/**/*.html')
			.pipe(watch('./frontend/app/**/*.html'))
			.pipe(gulp.dest(destination));
});

gulp.task('build', function() {
	runSequence(
		['clean'],
		['lint', 'minify-css', 'minify-js', 'copy-html-files', 'copy-bower-components']
	);
});

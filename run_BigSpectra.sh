#Configuration
combined_jar="bigSpectre_instrumented.jar";
pathToSpectralib="/home/ali/work/Idea/plugs/scalac-scoverage-plugin-master";
pathToplugin="/home/ali/work/Idea/plugs/sbt-scoverage-master";



# Record Current Directory
current_dir=$PWD;
echo $current_dir;

#Make Directory to put tempporary classes
mkdir temp


# Compile Sepctra tool
cd $pathToSpectralib;
sbt publishLocal;
echo "++Spectra Tool Compiled++";

# Compile sbt plugin
cd $pathToplugin;
sbt publishLocal;
echo "++Spectra Plugin Compiled";


#Compile and Instrument  Project
cd $current_dir;
sbt coverage compile;
echo "++Spark Program Instrumented";


# copy required jars to combine
cp /home/ali/work/Idea/target/scala-2.10/idea_2.10-1.0.jar temp/;
cp $pathToSpectralib/scalac-scoverage-runtime/target/scala-2.10/scalac-scoverage-runtime_2.10-0.14-SNAPSHOT.jar temp/;

cd temp;mkdir tmp


# Extrat the jars
jar -xvf idea_2.10-1.0.jar tmp;
jar -xvf scalac-scoverage-runtime_2.10-0.14-SNAPSHOT.jar tmp;

# Combine classses
cd tmp;
jar -cvf $combined_jar .;
cp $combined_jar $current_dir/.;
echo "++BigSpectra Compiled Instrumented jar";



cd $current_dir;


echo "Please use this BigSpectra's Instrumented jar to run your Spark Application to enable distrubted coverage: ";


# Removing Temporary Directory
rm -rf temp

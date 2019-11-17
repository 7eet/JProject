
echo "Enter Name of File: "
read fileName
echo "Enter commit message: "
read messg
echo "Enter branch name: "
read bName
git add $fileName
git commit -m "$messg "
git push origin $bName


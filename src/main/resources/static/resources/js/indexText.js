// Focus the input on load
//$('.the-editor-content').focus();

function doRichEditCommand(aName, aArg){
  document.execCommand(aName,false, aArg);
}
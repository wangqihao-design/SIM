# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: File.proto
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import symbol_database as _symbol_database
from google.protobuf.internal import builder as _builder
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\nFile.proto\x12\x04\x66ile\"6\n\x11UploadFileRequest\x12\x10\n\x08\x46ileName\x18\x01 \x01(\t\x12\x0f\n\x07\x43ontent\x18\x02 \x01(\x0c\"&\n\x12UploadFileResponse\x12\x10\n\x08\x46ilePath\x18\x01 \x01(\t\"@\n\x13\x44ownloadFileRequest\x12\x12\n\nInstanceId\x18\x01 \x01(\t\x12\x15\n\ralgorithmType\x18\x02 \x01(\t\"\'\n\x14\x44ownloadFileResponse\x12\x0f\n\x07\x43ontent\x18\x01 \x01(\x0c\x32\x99\x01\n\x0b\x46ileService\x12\x41\n\nUploadFile\x12\x17.file.UploadFileRequest\x1a\x18.file.UploadFileResponse(\x01\x12G\n\x0c\x44ownloadFile\x12\x19.file.DownloadFileRequest\x1a\x1a.file.DownloadFileResponse0\x01\x42\x30\n&com.simtech.sim.calcfileserver.serviceB\x04\x46ileP\x01\x62\x06proto3')

_globals = globals()
_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, _globals)
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'File_pb2', _globals)
if _descriptor._USE_C_DESCRIPTORS == False:

  DESCRIPTOR._options = None
  DESCRIPTOR._serialized_options = b'\n&com.simtech.sim.calcfileserver.serviceB\004FileP\001'
  _globals['_UPLOADFILEREQUEST']._serialized_start=20
  _globals['_UPLOADFILEREQUEST']._serialized_end=74
  _globals['_UPLOADFILERESPONSE']._serialized_start=76
  _globals['_UPLOADFILERESPONSE']._serialized_end=114
  _globals['_DOWNLOADFILEREQUEST']._serialized_start=116
  _globals['_DOWNLOADFILEREQUEST']._serialized_end=180
  _globals['_DOWNLOADFILERESPONSE']._serialized_start=182
  _globals['_DOWNLOADFILERESPONSE']._serialized_end=221
  _globals['_FILESERVICE']._serialized_start=224
  _globals['_FILESERVICE']._serialized_end=377
# @@protoc_insertion_point(module_scope)